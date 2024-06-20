(function() {//MakeCharsetMit
//---Start function: detectCharset
function charsetmit_detectCharset(path) {
}
//---End function

//---Start function: detectCharsetString
function charsetmit_detectCharsetString(path) {
  var res = "";
  return res;
}
//---End function

//---Start function: MakeCharsetMit
function MakeCharsetMit() {
  this.detectCharset=charsetmit_detectCharset
  this.detectCharsetString=charsetmit_detectCharsetString
}
//---End function

arguments[0].CharsetMit = new MakeCharsetMit()
})(window);//MakeCharsetMit
