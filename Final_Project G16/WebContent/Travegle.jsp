<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Travegle</title>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>


	 <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins&family=Noto+Sans+TC:wght@500&display=swap');
        @import url(//fonts.googleapis.com/earlyaccess/notosanstc.css);
        *{
            font-family: 'Poppins', cursive,'Noto Sans TC';
            font-family: 'Noto Sans TC', '微軟正黑體', sans-serif;
            box-sizing: border-box;
        }

        html {
            height: 100%;
        }

        body {
            background-image: url(./images/pexels-pixabay-163194.jpg);
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-position: center;
            background-size: cover;
            overflow: hidden;
        }

        .name{
            width: max-content;
            text-align: center;
            font-size: 100px;
            color: aliceblue;
            text-shadow: -1px -1px 0 black
        }

        .name-place{
            margin-top: 20%;
        }

        .search-place{
            margin-top: 2%;
        } 

        .search-bar{
            text-align: center;
            background-color:  rgb(128, 121, 108);
            opacity: 1;
            border: none;
            border-radius: 15px;
            width: 60%;
            height: 35px;
        }

        .search-bar:hover{
            text-align: center;
            background-color: rgb(247, 241, 233);
            opacity: 1;
            box-shadow: 0px 20px 18px rgba(15, 15, 15, 0.411);
            border-radius: 25px;
            border: none;
            width: 60%;
            height: 35px;
            transition: all .3s ease;
        }

        /*去掉點擊的黑外框*/
        input{
            border:0;
            outline:0;
        }

        input:focus{
            outline:none!important;
        }

        /*placeholder預設灰字改顏色*/
        ::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */
            color: rgb(238, 236, 236);
            opacity: 1; /* Firefox */
        }

        .walk-img{
            width: 150px;
        }

        .ballon{
            width: 150px;
            bottom: 20%;
            position: absolute;
            top: 2%; 
            right: 32%;
        }

        /*試寫動畫 設計成一個div讓他整個跑*/
        .walking {
            width: 80px;
            height: 100px;
            display: block;
            position: relative;

            /* animation 參數設定 */
            animation-name: MoveToRight;    /*動畫名稱，需與 keyframe 名稱對應*/
            animation-duration: 12s;    /*動畫持續時間，單位為秒*/
            animation-delay: 0s;    /*動畫延遲開始時間*/
            animation-iteration-count: infinite;    /*動畫次數，infinite 為無限次*/    
        }

        /* 關鍵影格(@keyframe) */

        @keyframes MoveToRight {
            from { left: 10%; }
            to { left: 45%; }
        }

        @media(max-width:600px){
            .ballon{
                display: none;
            }
        }
    </style>
    
</head>
<body>

    <form action="${requestUri}" method="get">
        <div style=" display: flex; flex-direction: column; place-content: center;">
            <div class="container">
                
                <div class="row justify-content-center name-place">
                    <h1 class="name col">Travegle</h1>
                </div>
                
            </div>
        
            <div class="container">
                <div class="row justify-content-center search-place">
                    <div class="col" style="place-content: center; display: flex">
                        <input onclick = "googleTranslateElementInit()" name='keyword' type="text" placeholder="&#xF002;  type something to search" class="search-bar" style="font-family:Arial, FontAwesome"/>
                    </div>
                </div>
            </div>
            
            <div class="container">
                <div class="row justify-content-center" style="place-content: center; display: flex">
                    <div class="walking col"><img src="./images/walk.gif" alt="" class="walk-img"></div>
                </div>
            </div>
        </div>

        <div class="ballon"><img src="./images/balloon.gif" alt=""></div>
		<a href ='http://localhost:8080/Final_Project/TestProject'></a>
    </form>
    <!-- translate -->     
     <script type="text/javascript" src="https://translate.google.com/translate_a/element.js?cb=googleTranslateElementInit">
		var googleTranslateElement; //global var for Google Translate Element
		
		function googleTranslateElementInit() {
		
		    if (googleTranslateElement) return; //var being non-empty means element already created
		    //store Google Translate Element in our var
		    googleTranslateElement = new google.translate.TranslateElement({pageLanguage: 'auto', includedLanguages: 'en,ko,ja,id,ms,th,vi,zh-CN,zh-TW', layout: google.translate.TranslateElement.InlineLayout.HORIZONTAL},'google_translate_element')return; 
	
		}
		
	</script>
	
	
    
    
    <!-- bootstrap -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
        
</body>
</html>