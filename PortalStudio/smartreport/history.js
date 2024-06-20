/**
 * Created by Matteo on 19/01/2015.
 */

 /* exported History */
var History = function (name) {


    function destroy () {
        for (var key, i=sessionStorage.length-1; i>=0; i--) {
            key = sessionStorage.key(i);
            if (key.indexOf(sessionName)==0) {
                sessionStorage.removeItem(key);
            }
        }
    }
    window.addEventListener( 'unload', destroy, false );

    this.clear = function () {
        destroy();
        sessionStorage[sessionName + "_pointer"] = -1;
        sessionStorage[sessionName + "_length"] = 0;
    }

    this.onRevert = function (/*obj*/) {
        //alert('non implementato')
    }

    this.onPush = function () {
        //alert('non implementato')
    }

    try {
        'sessionStorage' in window && window['sessionStorage'] !== null;
    } catch (e) {
        return false;
    }

    this.getMD5 = function(objJSON) {
        var jsonStr = JSON.stringify(objJSON);
        return this.md5(jsonStr);
    }

    //md5 lib
    !function (a) {
        "use strict";
        function b(a, b) {
            var c = (65535 & a) + (65535 & b), d = (a >> 16) + (b >> 16) + (c >> 16);
            return d << 16 | 65535 & c
        }
        function c(a, b) {
            return a << b | a >>> 32 - b
        }
        function d(a, d, e, f, g, h) {
            return b(c(b(b(d, a), b(f, h)), g), e)
        }
        function e(a, b, c, e, f, g, h) {
            return d(b & c | ~b & e, a, b, f, g, h)
        }
        function f(a, b, c, e, f, g, h) {
            return d(b & e | c & ~e, a, b, f, g, h)
        }
        function g(a, b, c, e, f, g, h) {
            return d(b ^ c ^ e, a, b, f, g, h)
        }
        function h(a, b, c, e, f, g, h) {
            return d(c ^ (b | ~e), a, b, f, g, h)
        }
        function i(a, c) {
            a[c >> 5] |= 128 << c % 32, a[(c + 64 >>> 9 << 4) + 14] = c;
            var d, i, j, k, l, m = 1732584193, n = -271733879, o = -1732584194, p = 271733878;
            for (d = 0; d < a.length; d += 16)
                i = m, j = n, k = o, l = p, m = e(m, n, o, p, a[d], 7, -680876936), p = e(p, m, n, o, a[d + 1], 12, -389564586), o = e(o, p, m, n, a[d + 2], 17, 606105819), n = e(n, o, p, m, a[d + 3], 22, -1044525330), m = e(m, n, o, p, a[d + 4], 7, -176418897), p = e(p, m, n, o, a[d + 5], 12, 1200080426), o = e(o, p, m, n, a[d + 6], 17, -1473231341), n = e(n, o, p, m, a[d + 7], 22, -45705983), m = e(m, n, o, p, a[d + 8], 7, 1770035416), p = e(p, m, n, o, a[d + 9], 12, -1958414417), o = e(o, p, m, n, a[d + 10], 17, -42063), n = e(n, o, p, m, a[d + 11], 22, -1990404162), m = e(m, n, o, p, a[d + 12], 7, 1804603682), p = e(p, m, n, o, a[d + 13], 12, -40341101), o = e(o, p, m, n, a[d + 14], 17, -1502002290), n = e(n, o, p, m, a[d + 15], 22, 1236535329), m = f(m, n, o, p, a[d + 1], 5, -165796510), p = f(p, m, n, o, a[d + 6], 9, -1069501632), o = f(o, p, m, n, a[d + 11], 14, 643717713), n = f(n, o, p, m, a[d], 20, -373897302), m = f(m, n, o, p, a[d + 5], 5, -701558691), p = f(p, m, n, o, a[d + 10], 9, 38016083), o = f(o, p, m, n, a[d + 15], 14, -660478335), n = f(n, o, p, m, a[d + 4], 20, -405537848), m = f(m, n, o, p, a[d + 9], 5, 568446438), p = f(p, m, n, o, a[d + 14], 9, -1019803690), o = f(o, p, m, n, a[d + 3], 14, -187363961), n = f(n, o, p, m, a[d + 8], 20, 1163531501), m = f(m, n, o, p, a[d + 13], 5, -1444681467), p = f(p, m, n, o, a[d + 2], 9, -51403784), o = f(o, p, m, n, a[d + 7], 14, 1735328473), n = f(n, o, p, m, a[d + 12], 20, -1926607734), m = g(m, n, o, p, a[d + 5], 4, -378558), p = g(p, m, n, o, a[d + 8], 11, -2022574463), o = g(o, p, m, n, a[d + 11], 16, 1839030562), n = g(n, o, p, m, a[d + 14], 23, -35309556), m = g(m, n, o, p, a[d + 1], 4, -1530992060), p = g(p, m, n, o, a[d + 4], 11, 1272893353), o = g(o, p, m, n, a[d + 7], 16, -155497632), n = g(n, o, p, m, a[d + 10], 23, -1094730640), m = g(m, n, o, p, a[d + 13], 4, 681279174), p = g(p, m, n, o, a[d], 11, -358537222), o = g(o, p, m, n, a[d + 3], 16, -722521979), n = g(n, o, p, m, a[d + 6], 23, 76029189), m = g(m, n, o, p, a[d + 9], 4, -640364487), p = g(p, m, n, o, a[d + 12], 11, -421815835), o = g(o, p, m, n, a[d + 15], 16, 530742520), n = g(n, o, p, m, a[d + 2], 23, -995338651), m = h(m, n, o, p, a[d], 6, -198630844), p = h(p, m, n, o, a[d + 7], 10, 1126891415), o = h(o, p, m, n, a[d + 14], 15, -1416354905), n = h(n, o, p, m, a[d + 5], 21, -57434055), m = h(m, n, o, p, a[d + 12], 6, 1700485571), p = h(p, m, n, o, a[d + 3], 10, -1894986606), o = h(o, p, m, n, a[d + 10], 15, -1051523), n = h(n, o, p, m, a[d + 1], 21, -2054922799), m = h(m, n, o, p, a[d + 8], 6, 1873313359), p = h(p, m, n, o, a[d + 15], 10, -30611744), o = h(o, p, m, n, a[d + 6], 15, -1560198380), n = h(n, o, p, m, a[d + 13], 21, 1309151649), m = h(m, n, o, p, a[d + 4], 6, -145523070), p = h(p, m, n, o, a[d + 11], 10, -1120210379), o = h(o, p, m, n, a[d + 2], 15, 718787259), n = h(n, o, p, m, a[d + 9], 21, -343485551), m = b(m, i), n = b(n, j), o = b(o, k), p = b(p, l);
            return[m, n, o, p]
        }
        function j(a) {
            var b, c = "";
            for (b = 0; b < 32 * a.length; b += 8)
                c += String.fromCharCode(a[b >> 5] >>> b % 32 & 255);
            return c
        }
        function k(a) {
            var b, c = [];
            for (c[(a.length >> 2) - 1] = void 0, b = 0; b < c.length; b += 1)
                c[b] = 0;
            for (b = 0; b < 8 * a.length; b += 8)
                c[b >> 5] |= (255 & a.charCodeAt(b / 8)) << b % 32;
            return c
        }
        function l(a) {
            return j(i(k(a), 8 * a.length))
        }
        function m(a, b) {
            var c, d, e = k(a), f = [], g = [];
            for (f[15] = g[15] = void 0, e.length > 16 && (e = i(e, 8 * a.length)), c = 0; 16 > c; c += 1)
                f[c] = 909522486 ^ e[c], g[c] = 1549556828 ^ e[c];
            return d = i(f.concat(k(b)), 512 + 8 * b.length), j(i(g.concat(d), 640))
        }
        function n(a) {
            var b, c, d = "0123456789abcdef", e = "";
            for (c = 0; c < a.length; c += 1)
                b = a.charCodeAt(c), e += d.charAt(b >>> 4 & 15) + d.charAt(15 & b);
            return e
        }
        function o(a) {
            return unescape(encodeURIComponent(a))
        }
        function p(a) {
            return l(o(a))
        }
        function q(a) {
            return n(p(a))
        }
        function r(a, b) {
            return m(o(a), o(b))
        }
        function s(a, b) {
            return n(r(a, b))
        }
        function t(a, b, c) {
            return b ? c ? r(b, a) : s(b, a) : c ? p(a) : q(a)
        }
        /*"function" == typeof define && define.amd ? define(function () {
            return t
        }) : a.md5 = t*/
        if(!a.md5) a.md5 = t;
    }(this);

    //BiMap
    var BiMap = (function () {
        BiMap.prototype.klength = 0;

        BiMap.prototype.vlength = 0;

        BiMap.prototype.kindex = 0;

        BiMap.prototype.throwOnError = false;

        function BiMap(A) {
            var k, v;
            this.kv = {};
            this.vk = {};
            if (A != null) {
                for (k in A) {
                    v = A[k];
                    this.push(k, v);
                }
            }
        }

        BiMap.prototype.push = function (k, v) {
            return this.insert(k, v, "push");
        };

        BiMap.prototype.appendKey = function (k, v) {
            return this.insert(k, v, "appendKey");
        };

        BiMap.prototype.appendVal = function (k, v) {
            return this.insert(k, v, "appendVal");
        };

        BiMap.prototype.set = function (k, v) {
            return this.insert(k, v, "set");
        };

        BiMap.prototype.type = function (a) {
            var t;
            t = typeof a;
            if (t === "number" && a !== a) {
                return "NaN";
            }
            if (t !== "object") {
                return t;
            }
            t = toString.call(a);
            if (t === "[object Object]") {
                return "object";
            }
            if (t === "[object Array]") {
                return "array";
            }
            if (t === "[object Boolean]") {
                return "boolean";
            }
            if (t === "[object Null]") {
                return "null";
            }
        };

        BiMap.prototype._assign = function (k, v, type, reverse) {
            var dir, i, rdir, _i, _len;
            if (type == null) {
                type = "push";
            }
            if (reverse == null) {
                reverse = false;
            }
            if (k > this.kindex) {
                this.kindex++;
            }
            dir = reverse ? "vk" : "kv";
            rdir = dir === "vk" ? "kv" : "vk";
            if (type === "push") {
                if (!((this[dir][k] != null) || this[rdir][void 0] === k || this[rdir][null] === k)) {
                    this[dir][k] = v;
                    return true;
                } else {
                    return this.error("" + dir + " mapping for " + k + " already exists");
                }
            } else if (type === "appendVal") {
                if (reverse) {
                    if (this.vk[k] != null) {
                        if ("array" !== this.type(this.vk[k])) {
                            this.vk[k] = [this.vk[k]];
                        }
                        this.vk[k][this.type(v) === "array" ? "concat" : "push"](v);
                    } else {
                        this.vk[k] = v;
                    }
                    return true;
                }
                if (this.kv[k] == null) {
                    this.kv[k] = [];
                } else if ("array" !== this.type(this.kv[k])) {
                    this.kv[k] = [this.kv[k]];
                }
                this.kv[k][this.type(v) === "array" ? "concat" : "push"](v);
                if ("array" === this.type(v)) {
                    for (_i = 0, _len = v.length; _i < _len; _i++) {
                        i = v[_i];
                        this.kv[k].push(i);
                    }
                }
                return true;
            } else if (type === "set") {
                this[dir][k] = v;
                return true;
            }
        };

        BiMap.prototype.insert = function (k, v, type) {
            var ktype, vtype;
            if (type == null) {
                type = "push";
            }
            if (k == null) {
                return this.error("At least one argument required by insert()");
            }
            ktype = this.type(k);
            if (v == null) {
                if ("array" === this.type(k)) {
                    return (function () {
                        var _i, _len, _results;
                        _results = [];
                        for (_i = 0, _len = k.length; _i < _len; _i++) {
                            v = k[_i];
                            _results.push(this.insert(++this.kindex - 1, v, type));
                        }
                        return _results;
                    }).call(this);
                } else if ("object" === this.type(k)) {
                    return this.traverse(k, (function (v, path) {
                        return this.insert(path, v, type);
                    }).bind(this));
                } else {
                    return this.insert(++this.kindex - 1, k, type);
                }
            } else if (this.type(k) === "number" && k > this.kindex) {
                this.kindex = k + 1;
            }
            vtype = this.type(v);
            if (vtype === "object") {
                return this.traverse(v, (function (v, path) {
                    return this.insert("" + k + "." + path, v, type);
                }).bind(this));
            } else if (vtype === "array") {
                if (ktype === "array") {
                    this.insertArray(v, k, type, true);
                }
                return this.insertArray(k, v, type);
            } else if (ktype === "array") {
                return this.insertArray(v, k, type, true);
            } else {
                if (this._assign(k, v, type)) {
                    return this._assign(v, k, type, true);
                }
                return false;
            }
        };

        BiMap.prototype.insertArray = function (k, array, type, reverse) {
            var i, r, _i, _len;
            if (type == null) {
                type = "push";
            }
            if (reverse == null) {
                reverse = false;
            }
            if (this.type(k) !== "array") {
                this._assign(k, array, type, reverse);
            }
            r = (function () {
                var _i, _len, _results;
                _results = [];
                for (_i = 0, _len = array.length; _i < _len; _i++) {
                    i = array[_i];
                    _results.push(this._assign(i, k, type, !reverse));
                }
                return _results;
            }).call(this);
            for (_i = 0, _len = r.length; _i < _len; _i++) {
                i = r[_i];
                if (!i) {
                    return false;
                }
            }
            return true;
        };

        BiMap.prototype.traverse = function (obj, cb) {
            var k, npath, path, v, _results;
            path = arguments[2] || "";
            if ("object" === this.type(obj)) {
                _results = [];
                for (k in obj) {
                    v = obj[k];
                    npath = path;
                    if (path.length > 0) {
                        npath += ".";
                    }
                    npath += k;
                    _results.push(this.traverse(v, cb, npath));
                }
                return _results;
            } else {
                return cb(obj, path);
            }
        };

        BiMap.prototype.setNull = function (k, v) {
            this.kv[k] = v;
            this.vk[v] = k;
            this.kindex++;
            return true;
        };

        BiMap.prototype.error = function (e) {
            if (this.throwOnError) {
                throw new Error(e);
            }
            return false;
        };

        BiMap.prototype.removeKey = function (k) {
            var i, index, _i, _len, _ref;
            if (this.type(this.kv[k]) === "array") {
                _ref = this.kv[k];
                for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                    i = _ref[_i];
                    if (this.type(this.vk[i]) === "array") {
                        index = this.vk[i].indexOf(k);
                        if (index !== -1) {
                            this.vk[i].splice(index);
                        }
                    } else {
                        if (this.vk[i] === k) {
                            delete this.vk[i];
                        }
                    }
                }
            } else {
                delete this.vk[this.kv[k]];
            }
            return delete this.kv[k];
        };

        BiMap.prototype.removeVal = function (v) {
            var i, index, _i, _len, _ref;
            if (this.type(this.vk[v]) === "array") {
                _ref = this.vk[v];
                for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                    i = _ref[_i];
                    if (this.type(this.kv[i]) === "array") {
                        index = this.kv[i].indexOf(v);
                        if (index !== -1) {
                            this.kv[i].splice(index);
                        }
                    } else {
                        if (this.kv[i] === v) {
                            delete this.kv[i];
                        }
                    }
                }
            } else {
                delete this.kv[this.vk[v]];
            }
            return delete this.vk[v];
        };

        BiMap.prototype.key = function (k) {
            return this.kv[k];
        };

        BiMap.prototype.val = function (v) {
            return this.vk[v];
        };

        return BiMap;

    })();

    //Base64
    var Base64 = {
        // private property
        _keyStr: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
        // public method for encoding
        encode: function (instr) {
            var output = "";
            var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
            var i = 0;
            var input = Base64._utf8_encode(instr);
            while (i < input.length) {
                chr1 = input.charCodeAt(i++);
                chr2 = input.charCodeAt(i++);
                chr3 = input.charCodeAt(i++);
                enc1 = chr1 >> 2;
                enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
                enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
                enc4 = chr3 & 63;
                if (isNaN(chr2)) {
                    enc3 = enc4 = 64;
                } else if (isNaN(chr3)) {
                    enc4 = 64;
                }
                output = output +
                        this._keyStr.charAt(enc1) + this._keyStr.charAt(enc2) +
                        this._keyStr.charAt(enc3) + this._keyStr.charAt(enc4);
            }
            return output;
        },
        // public method for decoding
        decode: function (instr) {
            var output = "";
            var chr1, chr2, chr3;
            var enc1, enc2, enc3, enc4;
            var i = 0;
            var input = instr.replace(/[^A-Za-z0-9\+\/\=]/g, "");
            while (i < input.length) {
                enc1 = this._keyStr.indexOf(input.charAt(i++));
                enc2 = this._keyStr.indexOf(input.charAt(i++));
                enc3 = this._keyStr.indexOf(input.charAt(i++));
                enc4 = this._keyStr.indexOf(input.charAt(i++));
                chr1 = (enc1 << 2) | (enc2 >> 4);
                chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
                chr3 = ((enc3 & 3) << 6) | enc4;
                output = output + String.fromCharCode(chr1);
                if (enc3 != 64) {
                    output = output + String.fromCharCode(chr2);
                }
                if (enc4 != 64) {
                    output = output + String.fromCharCode(chr3);
                }
            }
            output = Base64._utf8_decode(output);
            return output;
        },
        // private method for UTF-8 encoding
        _utf8_encode: function (input) {
            var string = input.replace(/\r\n/g, "\n");
            var utftext = "";
            for (var n = 0; n < string.length; n++) {
                var c = string.charCodeAt(n);
                if (c < 128) {
                    utftext += String.fromCharCode(c);
                }
                else if ((c > 127) && (c < 2048)) {
                    utftext += String.fromCharCode((c >> 6) | 192);
                    utftext += String.fromCharCode((c & 63) | 128);
                }
                else {
                    utftext += String.fromCharCode((c >> 12) | 224);
                    utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                    utftext += String.fromCharCode((c & 63) | 128);
                }
            }
            return utftext;
        },
        // private method for UTF-8 decoding
        _utf8_decode: function (input) {
            var utftext = input;
            var string = "";
            var i = 0;
            var c, c3, c2;
            c = c3 = c2 = 0;
            while (i < utftext.length) {
                c = utftext.charCodeAt(i);
                if (c < 128) {
                    string += String.fromCharCode(c);
                    i++;
                }
                else if ((c > 191) && (c < 224)) {
                    c2 = utftext.charCodeAt(i + 1);
                    string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
                    i += 2;
                }
                else {
                    c2 = utftext.charCodeAt(i + 1);
                    c3 = utftext.charCodeAt(i + 2);
                    string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
                    i += 3;
                }
            }
            return string;
        }
    }

    var startCode = 256;
    var sessionName = name + "_" + new Date().getTime();
    var lastMD5 = "";

    var tree = new BiMap();
    var code = startCode;

    this.hasUndo = function () {
        return (sessionStorage[sessionName + "_pointer"] > 0);
    }

    this.hasRedo = function () {
        return ((sessionStorage[sessionName + "_length"] - 1) > sessionStorage[sessionName + "_pointer"]);
    }

    this.undo = function () {
        if (this.hasUndo()) {
            var a = decode(sessionStorage[sessionName + "_" + --sessionStorage[sessionName + "_pointer"]]);
            lastMD5 = this.md5(a);
            try {
                return JSON.parse(a);
                //this.onRevert(JSON.parse(a));
            } catch (e) {
                return null;
            }
        } else {
            return null;
        }
    }

    this.redo = function () {
        if (this.hasRedo()) {
            var a = decode(sessionStorage[sessionName + "_" + ++sessionStorage[sessionName + "_pointer"]]);
            lastMD5 = this.md5(a);
            try {
                return JSON.parse(a);
                //this.onRevert(JSON.parse(a));
            } catch (e) {
                return null;
            }
        } else {
            return null;
        }
    }

    this.current = function () {
        return JSON.parse(decode(sessionStorage[sessionName + "_" + sessionStorage[sessionName + "_pointer"]]));
    }

    this.push = function (objJSON) {
        var jsonStr = JSON.stringify(objJSON);
        var md5s = this.md5(jsonStr);
        if (md5s == lastMD5) {
            return;
        }
        lastMD5 = md5s;
        //do push
        sessionStorage[sessionName + "_" + (++sessionStorage[sessionName + "_pointer"])] = encode(jsonStr);
        if (sessionStorage[sessionName + "_pointer"] != sessionStorage[sessionName + "_length"]) {
            //for debugging
            sessionStorage[sessionName + "_length"] = parseInt(sessionStorage[sessionName + "_pointer"]) + 1;
        } else {
            sessionStorage[sessionName + "_length"]++;
        }
    }

    var encode = function (decodedString) {
        var utf = Base64.encode(decodedString);
        var out = "";
        var currChar;

        var phrase = utf.charAt(0);
        for (var i = 1; i < utf.length; i++) {
            currChar = utf.charAt(i);
            if (tree.key(phrase + currChar) != null) {
                phrase += currChar;
            } else {
                out += (phrase.length > 1 ? String.fromCharCode(tree.key(phrase)) : phrase);
                tree.push(phrase + currChar, code);
                code++;
                phrase = currChar;
            }
        }
        out += (phrase.length > 1 ? String.fromCharCode(tree.key(phrase)) : phrase);
        return (out);
    }

    var decode = function (encodedString) {
        var dec = encodedString;
        var currChar = "";
        var oldPhrase = "";
        var out = "";
        var phrase;
        for (var i = 0; i < dec.length; i++) {
            var currCode = dec.charCodeAt(i);
            if (currCode < startCode) {
                phrase = dec.charAt(i);
            } else {
                phrase = tree.val(currCode) ? tree.val(currCode) : (oldPhrase + currChar);
            }
            out += phrase;
            currChar = phrase.charAt(0);
            oldPhrase = phrase;
        }
        return Base64.decode(out);
    }

    sessionStorage[sessionName + "_pointer"] = -1;
    sessionStorage[sessionName + "_length"] = 0;

}

//var historyStack = new History("InfinityAnalytics");
