;/*!common/lib/wdzjBridge.js*/
window.wdzjBridge = window.wdzjBridge || {}, function () {
    function o() {
        for (var o = 0, e = {}; o < arguments.length; o++) {
            var n = arguments[o];
            for (var t in n)e[t] = n[t]
        }
        return e
    }

    function e(n) {
        function t(e, i, a) {
            var r;
            if ("undefined" != typeof document) {
                if (arguments.length > 1) {
                    if (a = o({path: "/"}, t.defaults, a), "number" == typeof a.expires) {
                        var d = new Date;
                        d.setMilliseconds(d.getMilliseconds() + 864e5 * a.expires), a.expires = d
                    }
                    try {
                        r = JSON.stringify(i), /^[\{\[]/.test(r) && (i = r)
                    } catch (s) {
                    }
                    return i = n.write ? n.write(i, e) : encodeURIComponent(String(i)).replace(/%(23|24|26|2B|3A|3C|3E|3D|2F|3F|40|5B|5D|5E|60|7B|7D|7C)/g, decodeURIComponent), e = encodeURIComponent(String(e)), e = e.replace(/%(23|24|26|2B|5E|60|7C)/g, decodeURIComponent), e = e.replace(/[\(\)]/g, escape), document.cookie = [e, "=", i, a.expires ? "; expires=" + a.expires.toUTCString() : "", a.path ? "; path=" + a.path : "", a.domain ? "; domain=" + a.domain : "", a.secure ? "; secure" : ""].join("")
                }
                e || (r = {});
                for (var p = document.cookie ? document.cookie.split("; ") : [], c = /(%[0-9A-Z]{2})+/g, l = 0; l < p.length; l++) {
                    var m = p[l].split("="), f = m.slice(1).join("=");
                    '"' === f.charAt(0) && (f = f.slice(1, -1));
                    try {
                        var h = m[0].replace(c, decodeURIComponent);
                        if (f = n.read ? n.read(f, h) : n(f, h) || f.replace(c, decodeURIComponent), this.json)try {
                            f = JSON.parse(f)
                        } catch (s) {
                        }
                        if (e === h) {
                            r = f;
                            break
                        }
                        e || (r[h] = f)
                    } catch (s) {
                    }
                }
                return r
            }
        }

        return t.set = t, t.get = function (o) {
            return t.call(t, o)
        }, t.getJSON = function () {
            return t.apply({json: !0}, [].slice.call(arguments))
        }, t.defaults = {}, t.remove = function (e, n) {
            t(e, "", o(n, {expires: -1}))
        }, t.withConverter = e, t
    }

    window.wdzjBridge.Cookies = e(function () {
    })
}(window, window.wdzjBridge), function (o, e) {
    function n() {
        for (var o = a.split("."), e = b.split("."), n = 0; 3 > n; n++) {
            var t = Number(o[n]), i = Number(e[n]);
            if (t > i)return 1;
            if (i > t)return -1;
            if (!isNaN(t) && isNaN(i))return 1;
            if (isNaN(t) && !isNaN(i))return -1
        }
        return 0
    }

    e.compareVersions = n
}(window, window.wdzjBridge), function (o, e) {
    console.log("----- bridge init begin -----");
    var n = navigator.userAgent, t = (Array.prototype.slice, Array.isArray, e.Cookies.get("appversion")), i = e.Cookies.get("wdzjmatrix") || e.Cookies.get("wdzjjishu") || e.Cookies.get("wdzjtansuo"), a = "wdzj", r = {};
    e.debug = 0;
    var d = n.match(/(Android);?[\s\/]+([\d.]+)?/), s = n.match(/(iPad).*OS\s([\d_]+)/), p = n.match(/(iPod)(.*OS\s([\d_]+))?/), c = !s && n.match(/(iPhone\sOS)\s([\d_]+)/), l = n.match(/(MicroMessenger)/), m = n.match(/(\sQQ)/), f = n.match(new RegExp("(" + a + ")\\/([\\d.]+)"));
    d && (r.android = !0, r.version = d[2]), c && !p && (r.ios = r.iphone = !0, r.version = c[2].replace(/_/g, ".")), s && (r.ios = r.ipad = !0, r.version = s[2].replace(/_/g, ".")), p && (r.ios = r.ipod = !0, r.version = p[3] ? p[3].replace(/_/g, ".") : null), l && (r.wechat = !0), m && (r.qq = !0), f && (r.wdzj = !0, r.appVersion = f[2]), t && (r.wdzj = !0, r.appVersion = t), r.matrix = !!i, e.close = function () {
        location.href = "http://closewebview"
    }, e.createScript = function (o) {
        var e = document.createElement("script");
        return e.type = "text/javascript", e.src = o, document.getElementsByTagName("head")[0].appendChild(e), e
    }, e.closeAndRefresh = function (o) {
        console.log("close and refresh");
        var n = parseFloat(e.Cookies.get("appversion"));
        return n && 5 > n ? void(o && o()) : void(location.href = "http://refreshwindows")
    }, e.onShare = function () {
    }, e.os = r
}(window, window.wdzjBridge), function (o, e) {
    var n = '<div class="footer-appdown">\n  <i class="closeapp"></i>\n  <div class="wdzj-app"><i></i><span>网贷之家</span><br>提供最新最全P2P网贷资讯</div>\n  <a href="http://a.app.qq.com/o/simple.jsp?pkgname=com.wdzj.app" class="downapp">点击下载</a>\n</div>\n', t = ".footer-appdown{\n  position: fixed;\n  z-index: 10;\n  left: 0px;\n  bottom: 0px;\n  width: 100%;\n  background-color: rgba(0,0,0,0.5);\n opacity: 0; \n  padding: 5px 0;\n  -webkit-transform: translate3d(0, 53px, 0); \n transform: translate3d(0, 50px, 0);\n -webkit-transition: all .5s linear;\n transition: all .5s linear;}\n\n.closeapp{\n  display: block;\n  width: 16.8px;\n  height: 16.8px;\n  background-image: url(http://m.wdzj.com/static/index/images/home/closeapp.png);\n  background-size: 86% auto;\n  background-repeat: no-repeat;\n  background-position: center;\n  float: left;\n  margin-left: 2%;\n  margin-top: 10px;\n  cursor: pointer;\n}\n\n.wdzj-app{\n  float: left;\n  width: 60%;\n  color: #ffffff;\n  font-size: 11.2px;\n  margin-left: 3%;\n}\n\n.wdzj-app i{\n  display: inline-block;\n  width: 30.8px;\n  height: 30.8px;\n  background-image: url('http://comment.wdzj.com/static/wap/images/common/wdzj-app.png');\n  background-size: 100% auto;\n  background-repeat: no-repeat;\n  background-position: center;\n  float: left;\n  margin-right: 4%;\n  margin-top: 2.8px;\n}\n\n.wdzj-app span{\n  font-size: 14px;\n}\n\n.downapp{\n  display: block;\n  width: 84px;\n  height: 30.8px;\n  background-color: #fa4e46;\n  color: #ffffff;\n  font-size: 14px;\n  float: right;\n  border-radius: 6px;\n  text-align: center;\n  line-height: 30.8px;\n  margin-right: 2%;\n  margin-top: 4px;\n}\n", i = {
        android: "http://osscdn.wdzj.com/apk/wdzj.apk",
        ios: "https://itunes.apple.com/cn/app/wang-dai-zhi-jia/id687180281?mt=8",
        myapp: "http://a.app.qq.com/o/simple.jsp?pkgname=com.wdzj.app"
    }, a = i.myapp;
    e.os.wechat || e.os.qq || (e.os.android ? a = i.android : e.os.ios && (a = i.ios)), e.downloadUrl = a, e.wdzjDownload = {
        init: function (o) {
            this.opts = $.extend({
                bottom: 0,
                container: "body",
                originScroll: !0
            }, o), this.$container = $(this.opts.container), e.os.wdzj || "closeApp" !== e.Cookies.get("closeApp") && this.create()
        }, create: function () {
            $("<style/>", {text: t}).appendTo($("head")), this.$download = $(n), this.$download.find(".downapp").attr("href", a), this.$container.append(this.$download), this.opts.bottom && this.$download.css({
                "-webkit-transform": "translate3d(0,-" + (this.opts.bottom - 50) + "px,0)",
                transform: "translate3d(0,-" + (this.opts.bottom - 50) + "px,0)"
            }), this.bindEvents(), setTimeout(function () {
                this.show()
            }.bind(this), 100)
        }, bindEvents: function () {
            $(document).on("click", ".closeapp", function () {
                e.Cookies.set("closeApp", "closeApp", {expires: 1, domain: "wdzj.com"}), this.hide()
            }.bind(this))
        }, show: function () {
            this.$download && (this.$download.css("display", "block"), this.$download.css({
                opacity: 1,
                "-webkit-transform": "translate3d(0,-" + this.opts.bottom + "px,0)",
                transform: "translate3d(0,-" + this.opts.bottom + "px,0)"
            }))
        }, hide: function () {
            this.$download && this.$download.css("display", "none")
        }
    }
}(window, window.wdzjBridge), function (o, e) {
    function n(o, n) {
        function t(o) {
            function e(e) {
                o(e > 3e3 || document.hidden || document.webkitHidden ? 1 : 0)
            }

            var n, t = +new Date, i = 0;
            n = setInterval(function () {
                i++;
                var o = +new Date - t;
                (i >= 100 || o > 3e3) && (clearInterval(n), e(o))
            }, 20)
        }

        function i() {
            if (e.os.ios) {
                var i = parseFloat(e.os.version);
                if (i > 9)location.href = o; else {
                    var a = document.createElement("iframe");
                    a.src = o, a.style.display = "none", document.body.appendChild(a), setTimeout(function () {
                        document.body.removeChild(a)
                    }, 2e3)
                }
                n && t(function (o) {
                    n && n(o)
                })
            } else location.href = e.downloadUrl
        }

        i()
    }

    e.openApp = n
}(window, window.wdzjBridge), function (o, e) {
    var n = ['<div class="app_recom_div">', '<div class="app_recom_box">', "<h3><span>应用推荐</span></h3>", '<div class="app_recommend">', '<div class="rect_recom"></div>', '<div class="recom_cont">', '<img class="recom_logo" src="http://m.wdzj.com/static/wap/images/s-logo-rect.jpg">', '<div class="recom_text">', "<strong>网贷之家APP</strong>", "<div>您身边的网贷资讯专家</div>", "</div>", '<a href="#" class="recom_enter">进入</a>', "</div>", "</div>", "</div>", "</div>"].join(""), t = [".app_recom_div{overflow: hidden;background: #fff;padding-bottom: 10px;}", ".app_recom_box{margin:0 auto;}", ".app_recom_div h3{position:relative; font-size:13px; color:#727272; height:0; border-bottom:1px dashed #e1e1e1; text-align:center; font-weight:normal;  margin:20px 0;}", ".app_recom_div h3 span{position:absolute; left:50%; margin-left:-75px; top:-50%; margin-top:-10px; display:block; width:150px; background-color:#fff;}", ".app_recommend{position:relative; border:1px solid #e1e1e1;background-color:#fff; padding:10px; box-sizing:border-box; -webkit-box-sizing:border-box;}", ".rect_recom{position:absolute; left:0; top:0; background:url(http://m.wdzj.com/static/wap/images/s-rect.png) no-repeat; width:32px; height:25px; background-size:100% auto;}", ".recom_cont{overflow:hidden;}", ".recom_logo{float:left; width:34px !important; margin-top: 7px; border:1px solid #e1e1e1; border-radius: 8px;}", ".recom_text{float:left; margin-left:10px;}", ".recom_text strong{font-size:14px; font-weight:normal; color:#212121;}", ".recom_text div{font-size:12px; font-weight:normal; color:#727272;}", ".recom_enter{float:right; width:60px; height:28px; border:1px solid #65adf3; display:block; margin-top:10px; text-align:center; line-height:26px; color:#65adf3; border-radius:5px;}"].join("");
    e.wdzjMatrix = {
        init: function (o) {
            o && e.os.matrix && ($("<style/>", {text: t}).appendTo($("head")), this.$download = $(n), this.$download.find(".recom_enter").attr("href", e.downloadUrl), $(o).append(this.$download))
        }
    }
}(window, window.wdzjBridge);