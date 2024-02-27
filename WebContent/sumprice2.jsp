<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>月销售总计</title>

<style>
        * {
            padding: 0;
            margin: 0;
        }

        .shell {
            width: 100%;
            position: relative;
            padding: 80px 0;
            background-attachment: fixed;
            background-size: cover;
        }

        .shell:before {
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            background: rgba(99, 99, 99, 0.8);
            content: "";
        }

        .header {
            width: 100%;
            text-align: center;
            margin-bottom: 80px;
            position: relative;
        }

        .title {
            color: #fff;
            font-size: 46px;
            font-weight: normal;
            margin: 0;
        }

        .timeline {
            display: flex;
            margin: 0 auto;
            flex-wrap: wrap;
            flex-direction: column;
            max-width: 700px;
            position: relative;
        }

        .content-title {
            font-weight: normal;
            font-size: 66px;
            margin: -10px 0 0 0;
            transition: 0.4s;
            padding: 0 10px;
            box-sizing: border-box;
            color: #fff;
        }

        .content-desc {
            margin: 0;
            font-size: 15px;
            box-sizing: border-box;
            color: rgba(255, 255, 255, 0.7);
            line-height: 25px;
        }

        .timeline:before {
            position: absolute;
            left: 50%;
            width: 2px;
            height: 100%;
            margin-left: -1px;
            content: "";
            background: rgba(255, 255, 255, 0.07);
        }

        .item {
            padding: 40px 0;
            opacity: 0.3;
            filter: blur(2px);
            transition: 0.5s;
            box-sizing: border-box;
            width: calc(50% - 40px);
            display: flex;
            position: relative;
            transform: translateY(-80px);
        }

        .item:before {
            /* 设置在伪元素before中的内容  */
            content: attr(data-text);
            letter-spacing: 3px;
            width: 100%;
            position: absolute;
            color: rgba(255, 255, 255, 0.5);
            font-size: 13px;
            border-left: 2px solid rgba(255, 255, 255, 0.5);
            top: 70%;
            margin-top: -5px;
            padding-left: 15px;
            opacity: 0;
            right: calc(-100% - 56px);
            font: 900 20px '';
            letter-spacing: 5px;
        }

        .item:nth-child(even) {
            align-self: flex-end;
        }

        .item:nth-child(even):before {
            right: auto;
            text-align: right;
            left: calc(-100% - 56px);
            padding-left: 0;
            border-left: none;
            border-right: 2px solid rgba(255, 255, 255, 0.5);
            padding-right: 15px;
        }

        .item--active {
            opacity: 1;
            transform: translateY(0);
            filter: blur(0px);
        }

        .item--active:before {
            top: 50%;
            transition: 0.3s all 0.2s;
            opacity: 1;
        }

        .item--active .content-title {
            margin: -50px 0 20px 0;
        }

        .img {
            max-width: 100%;
            box-shadow: 0 10px 15px rgba(0, 0, 0, 0.4);
        }

        .subtitle {
            color: rgba(255, 255, 255, 0.5);
            font-size: 16px;
            letter-spacing: 5px;
            margin: 10px 0 0 0;
            font-weight: normal;
        }

        .footer {
            padding: 95px 0;
            text-align: center;
        }

        .footer a {
            color: #999;
            display: inline-block;
        }

        @media only screen and (max-width: 767px) {
            .item {
                align-self: baseline !important;
                width: 100%;
                padding: 0 30px 150px 80px;
            }

            .item:before {
                left: 10px !important;
                padding: 0 !important;
                top: 50px;
                text-align: center !important;
                width: 60px;
                border: none !important;
            }

            .item:last-child {
                padding-bottom: 40px;
            }
        }

        @media only screen and (max-width: 767px) {
            .timeline:before {
                left: 40px;
            }
        }
    </style>
</head>
<body>
<div class="shell" id="shell">
        <div class="header">
            <h2 class="title">本月销售总计</h2>
            <h3 class="subtitle">图书销售</h3>
        </div>
        <div class="timeline">
            <div class="item" data-text="下滑查看本月销售总计">
                <div class="content">
                    <img class="img" src="背景图片.jpg" />
                    <h2 class="content-title">2023</h2>
                    <p class="content-desc">
                       欢迎查看本月销售统计
                    </p>
                </div>
            </div>

            <div class="item" data-text="本月销售总金额:${sumprice }">
                <div class="content">
                    <img class="img" src="流浪者.jpg" />
                    <h2 class="content-title">2023  Jun</h2>
                    <p class="content-desc">
                        好的销售成绩离不开每一个人的努力~
                    </p>
                </div>
            </div>

            <div class="item" data-text="本月销售总量:${sumcnt }">
                <div class="content">
                    <img class="img" src="退货背景.jpg" />
                    <h2 class="content-title">2023 Jun</h2>
                    <p class="content-desc">
                        看看本月的书籍总销量吧~
                    </p>
                </div>
            </div>

            <div class="item" data-text="查询结束">
                <div class="content">
                    <img class="img" src="pass2.jpg" />
                    <h2 class="content-title">2023 Jun</h2>
                    <p class="content-desc">
                       继续加油，再接再厉~
                    </p>
                </div>
            </div>
    </div>
    <div class="footer"><a>页脚</a>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script>
        (function ($) {
            $.fn.timeline = function () {
                var selectors = {
                    id: $(this),
                    item: $(this).find(".item"),
                    activeClass: "item--active",
                    img: ".img"
                };
                // 将第一个时间轴项目激活，并设置时间轴背景图片为第一个项目的图片
                selectors.item.eq(0).addClass(selectors.activeClass);
                selectors.id.css(
                    "background-image",
                    "url(" +
                    selectors.item
                        .first()
                        .find(selectors.img)
                        .attr("src") +
                    ")"
                );
                // 获取时间轴项目的总数
                var itemLength = selectors.item.length;
                // 当页面滚动时，触发滚动事件
                $(window).scroll(function () {
                    var max, min;
                    // 获取页面滚动的距离
                    var pos = $(this).scrollTop();
                    selectors.item.each(function (i) {
                        // 获取当前时间轴项目的最小和最大高度
                        min = $(this).offset().top;
                        max = $(this).height() + $(this).offset().top;
                        var that = $(this);
                        // 如果滚动到最后一个项目，并且超过了当前项目高度的一半，
                        // 则将最后一个项目设置为激活状态，并设置背景图片为最后一个项目的图片
                        if (i == itemLength - 2 && pos > min + $(this).height() / 2) {
                            selectors.item.removeClass(selectors.activeClass);
                            selectors.id.css(
                                "background-image",
                                "url(" +
                                selectors.item
                                    .last()
                                    .find(selectors.img)
                                    .attr("src") +
                                ")"
                            );
                            selectors.item.last().addClass(selectors.activeClass);
                        }
                        // 如果当前滚动位置在当前项目的最小和最大高度之间，
                        // 则将当前项目设置为激活状态，并设置背景图片为当前项目的图片
                        else if (pos <= max - 10 && pos >= min) {
                            selectors.id.css(
                                "background-image",
                                "url(" +
                                $(this)
                                    .find(selectors.img)
                                    .attr("src") +
                                ")"
                            );
                            selectors.item.removeClass(selectors.activeClass);
                            $(this).addClass(selectors.activeClass);
                        }
                    });
                });
            };
        })(jQuery)
        /*
        最后，我们调用 timeline 插件并传入时间轴的 ID 作为参数。
        这将启用时间轴插件并为该时间轴绑定滚动事件。
        */
        $("#shell").timeline();
    </script>
</body>
</html>