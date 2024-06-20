/* HTMLMode */

// CodeMirror, copyright (c) by Marijn Haverbeke and others
// Distributed under an MIT license: https://codemirror.net/LICENSE

(function(mod) {

  // if (typeof exports == "object" && typeof module == "object") // CommonJS
  //   mod(require("../../lib/codemirror"), require("../../addon/mode/overlay"));
  // else if (typeof define == "function" && define.amd) // AMD
  //   define(["../../lib/codemirror", "../../addon/mode/overlay"], mod);
  // else // Plain browser env
    mod(CodeMirror);
})(function(CodeMirror) {
  "use strict";

  //jsStartState.localVars && globalVars

  CodeMirror.defineMode("htmlmode", function(config, parserConfig) {
    // var htmlmode = CodeMirror.getMode(config, {
    //   name: "htmlmode-tags",
    //   helperType: 'htmlmode'
    // });
    var htmlmode = CodeMirror.getMode(config, {});
    const jsmode = CodeMirror.getMode({}, "javascript");
    const jsStartState = jsmode.startState();
    const operator_regex = /#(if|else|endif|each|endeach|reactive|endreactive|variant|endvariant|translate|browser|endbrowser)|idPortlet/;
    if (!parserConfig || !parserConfig.base) return htmlmode;
    /**
     * End current expression from stream.pos to "}}".
     * Used for comment and ctrl expression
     * @param {*} stream
     */
    var endExpression = function(stream) {
      let ch;
      let end = false;
      while ((ch = stream.next()) != null && !end){
        if (ch == "}" && stream.next() == "}") {
          stream.eat("}");
          end = true;
        }
      }
    }
    /**
     * Match expression close and inner JS syntax
     * @param {Object} stream
     * @param {Object} stack
     * @returns {Object}
     */
    var expression = function (stream, stack) {
      let ch;
      let end = false;
      let start = stream.start;
      while ((ch = stream.peek()) != null && !end ){
        if (ch == "}" && stream.match(/}}/)) {
          stream.eat("}}");
          end = true;
          let before = stream.pos;
          stack.push({
            token: "close-bracket",
            pos: stream.pos,
            string: stream.string.substring(before, stream.pos)
          })
          // riposiziono lo start
          stream.start = start;
        } else if ( stream.match(operator_regex, false) ) {
          let before = stream.pos;
          // posiziono lo start per il parser JS
          stream.start = before;
          stream.match(operator_regex);
          stack.push({
            token: "macro",
            pos: stream.pos,
            string: stream.string.substring(before, stream.pos)
          })
        } else {
          let before = stream.pos;
          // posiziono lo start per il parser JS
          stream.start = before;
          stack.push({
            token: jsmode.token(stream, jsStartState),
            pos: stream.pos,
            string: stream.string.substring(before, stream.pos)
          })
        }
      }
      return stack;
    }

    function getTokens() {
      let stack = [];
      return {
        name: "htmlmode-tags",
        helperType: 'htmlmode',
        token: function(stream,state) {
          // aggiorno lo stack in caso di richiesta di token parziale con la tokenAt
          if( stream.pos == 0 ) {
            stack = [];
          }
          let ch;
          /**
           * start expresison
           * - {{
           * - {{!
           * - {{!--
           */
          if ( stream.match( /{{/ )) {
            stream.eatSpace();
            ch = stream.peek();
            /**
             * Comment
             */
            if( ch == "!") {
              endExpression(stream);
              return "comment";
            } else {
              /** Expresison or @ctrl
               * {{ exp
               * {{ @ctrl
               */
              if( ch == "@" && stream.match( /@[A-Za-z_]\w*/ ) ) {
                /**
                 * Identify {{ @ctrl_name }}
                 */
                endExpression(stream);
                return "ctrl"
              } else {
                let tempPos = stack.length ? stack[stack.length - 1].pos : stream.pos;
                /**
                 * Evaluate all expression and make stack of token
                 */
                stack = expression(stream, stack);
                /**
                 * Return to first token, the other are in stack and where
                 * used in next loop
                 */
                stream.pos = tempPos;
                stream.start = 0;
                return "open-bracket";
              }

            }
          }
          if( stack.length ){
            let state = stack.shift();
            stream.pos = state.pos;
            return state.token;
          }
          while (stream.next() != null && !stream.match(/{{/, false)) {}
          return null;
        },
        blockCommentStart: "{{!--",
        blockCommentEnd: "--}}"
      }

    }

    /**
     * Overload htmlmixed with htmlmode syntax. Read from {{ to }}.
     * Use stack to store token
     */
    htmlmode = CodeMirror.overlayMode( CodeMirror.getMode(config, parserConfig.base), getTokens());
    return htmlmode;
  });

  CodeMirror.defineMIME("text/x-htmlmode-template", "htmlmode");
});
