<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>排行榜</title>
  <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            min-height: 100vh;
            background: url(WebContent/流浪者.jpg) center / cover;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        main.table {
            width: 77vw;
            height: 80vh;
            background-color: #fff5;
            box-shadow: 0 8px 16px #0005;
            border-radius: 16px;
            overflow: hidden;
        }

        .header {
            width: 100%;
            height: 10%;
            background-color: #fff4;
            padding: 0 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header .input-group {
            width: 35%;
            height: 50%;
            background-color: #fff5;
            padding: 0 20px;
            border-radius: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            transition: .2s;
        }

        .header .input-group:hover {
            width: 45%;
            background-color: #fff8;
            box-shadow: 0 5px 40px #0002;
        }

        .header .input-group img {
            width: 20px;
            height: 20px;
        }

        .header .input-group input {
            width: 100%;
            background-color: transparent;
            border: none;
            outline: none;
        }

        .shell {
            width: 95%;
            max-height: calc(90% - 25px);
            background-color: #fffb;
            margin: 8px auto;
            border-radius: 10px;
            overflow: auto;
            overflow: overlay;
        }

        .shell::-webkit-scrollbar {
            width: 10px;
            height: 10px;
        }

        table {
            width: 100%;
        }

        td img {
            width: 36px;
            height: 36px;
            margin-right: 10px;
            border-radius: 50%;
            vertical-align: middle;
        }

        table,
        th,
        td {
            border-collapse: collapse;
            padding: 20px;
            text-align: left;
        }

        thead th {
            position: sticky;
            top: 0;
            left: 0;
            background-color: #d5d1defe;
            cursor: pointer;
        }

        /* 偶数行背景色 */
        tbody tr:nth-child(even) {
            background-color: #0000000b;
        }

        tbody tr:hover {
            background-color: #fff6 !important;
        }

        .button {
            padding: 5px 0;
            border-radius: 40px;
            text-align: center;
        }

        tr:nth-child(4n) .button {
            background-color: #86e49d;
            color: #006b21;
        }

        tr:nth-child(4n-1) .button {
            background-color: #ebc474;
        }

        tr:nth-child(4n+1) .button {
            background-color: #d893a3;
            color: #b30021;
        }

        tr:nth-child(4n+2) .button {
            background-color: #6fcaea;
        }
    </style>
</head>
<body>
 <main class="table">
        <section class="header">
            <h1>山羊の前端小窝</h1>
            <div class="input-group">
                <input type="search" placeholder="Search Data...">
                <img src="images/search.png">
            </div>
        </section>
        <section class="shell">
            <table>
                <thead>
                    <tr>
                        <th> Id🌙 </th>
                        <th> username💗</th>
                        <th> location💞</th>
                        <th> Last contact date💌</th>
                        <th> message🥰</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> 001 </td>
                        <td> <img src="images/lisa.jpg">Lisa</td>
                        <td> Korea </td>
                        <td> 2023-5-14 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 00S</td>
                        <td><img src="images/ikun.jpg"> IKUN </td>
                        <td> 篮球场 </td>
                        <td> 2020-3-14 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 002 </td>
                        <td><img src="images/金珍妮.jpg"> 金珍妮 </td>
                        <td> Korea </td>
                        <td> 2023-1-28 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 003</td>
                        <td><img src="images/金智秀.jpg"> 金智秀 </td>
                        <td> Korea </td>
                        <td> 2023-5-14 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 004</td>
                        <td><img src="images/朴彩英.jpg"> 朴彩英</td>
                        <td> Korea </td>
                        <td> 2023-3-07 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 005</td>
                        <td><img src="images/张娜英.jpg"> 张娜英 </td>
                        <td> Korea </td>
                        <td> 2022-8-22 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 006</td>
                        <td><img src="images/池秀媛.jpg">池秀媛 </td>
                        <td> Korea </td>
                        <td> 2023-3-14 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 007</td>
                        <td><img src="images/美依礼芽.jpg"> 美依礼芽 </td>
                        <td> Japan </td>
                        <td> 2023-4-12 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 008</td>
                        <td><img src="images/桥本环奈.jpg"> 桥本环奈 </td>
                        <td> Japan </td>
                        <td> 2023-2-17 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                    <tr>
                        <td> 009</td>
                        <td><img src="images/ikun.jpg"> IKUN </td>
                        <td> 篮球场 </td>
                        <td> 2020-3-14 </td>
                        <td>
                            <p class="button">发消息</p>
                        </td>
                    </tr>
                </tbody>
            </table>
        </section>
    </main>
</body>
</html>