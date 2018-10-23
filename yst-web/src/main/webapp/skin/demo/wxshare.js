wx.ready(function () {
    // ?????????
    wx.onMenuShareTimeline({
        title: wstitle,
        link: wslink,
        imgUrl: wsimg,
        success: function () {
            // alert('??????');
        },
        cancel: function () {
        }
    });

    // ????????
    wx.onMenuShareAppMessage({
        title: wstitle,
        desc: wsdesc,
        link: wslink,
        imgUrl: wsimg,
        success: function () {
            // alert('??????');
        },
        cancel: function () {
        }
    });

    // ?????Q
    wx.onMenuShareQQ({
        title: wstitle,
        desc: wsdesc,
        link: wslink,
        imgUrl: wsimg,
        success: function () {
            // alert('??????');
        },
        cancel: function () {
        }
    });

    // ???????????
    wx.onMenuShareWeibo({
        title: wstitle,
        desc: wsdesc,
        link: wslink,
        imgUrl: wsimg,
        success: function () {
            // alert('??????');
        },
        cancel: function () {
        }
    });

    // ?????Q???
    wx.onMenuShareQZone({
        title: wstitle,
        desc: wsdesc,
        link: wslink,
        imgUrl: wsimg,
        success: function () {
            // alert('??????');
        },
        cancel: function () {
        }
    });

});