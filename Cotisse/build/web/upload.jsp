<%-- 
    Document   : upload
    Created on : 4 août 2021, 10:58:03
    Author     : rindrarolando
--%>

<% if(session.getAttribute("sessionAdmin") != null){ %>
        
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Cotisse Madagascar</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <link rel="shortcut icon" type="image/x-icon" href="images/cotisse.jpg">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/core.css">
    <link rel="stylesheet" href="css/shortcode/shortcodes.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/custom.css">

    <script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>

<body>
 
    <div class="wrapper fixed__footer">
        
        <header id="header" class="htc-header header--3 bg__white">
            <div id="sticky-header-with-topbar" class="mainmenu__area sticky__header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3">
                            <div class="logo">
                                <a href="#">
                                    <img src="images/cotisse.jpg" alt="logo">
                                </a>
                            </div>
                        </div>
                        <div class="col-md-8 col-lg-8 col-sm-6 col-xs-6">
                            <nav class="mainmenu__nav hidden-xs hidden-sm">
                                <ul class="main__menu">
                                    <li class="drop"><a href="index.jsp">Acceuil</a></li>
                                    <li class="drop"><a href="listeVoyageAdmin.jsp">Liste Voyages</a></li>
                                    <li class="drop"><a href="upload.jsp">Upload Images</a></li>
                                    <li class="drop"><a href="listeReservations.jsp">Liste Reservations</a></li>
                                </ul>
                            </nav>
                            <div class="mobile-menu clearfix visible-xs visible-sm">
                                <nav id="mobile_dropdown">
                                    <ul>
                                    <li class="drop"><a href="index.jsp">Acceuil</a></li>
                                    <li class="drop"><a href="listeVoyageAdmin.jsp">Liste Voyages</a></li>
                                    <li class="drop"><a href="upload.jsp">Upload Images</a></li>
                                    <li class="drop"><a href="listeReservations.jsp">Liste Reservations</a></li>
                                    </ul>
                                </nav>
                            </div>                         
                        </div>

                        <div class="col-md-2 col-sm-4 col-xs-3">  
                            <ul class="menu-extra"></ul>
                        </div>
                    </div>
                    <div class="mobile-menu-area"></div>
                </div>
            </div>
            
        </header>
        
        
        
        <div class="htc__login__register bg__white ptb--130" style="background: rgba(0, 0, 0, 0) url(images/bg/5.jpg) no-repeat scroll center center / cover ;">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <ul class="login__register__menu" role="tablist">
                            <li role="presentation" class="login active"><a href="#login" role="tab" data-toggle="tab">Ajouter une ligne de Voyage.</a></li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="htc__login__register__wrap">
                            <div id="login" role="tabpanel" class="single__tabs__panel tab-pane fade in active">
                                
                                
                                <c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
                                    <form method="post" action="TraitementUpload" enctype="multipart/form-data">
                                        <p>
                                            <label for="description">Description du fichier : </label>
                                            <input type="text" name="description" id="description" />
                                        </p>
                                        <p>
                                            <label for="fichier">Fichier à envoyer : </label>
                                            <input type="file" name="fichier" id="fichier" />
                                        </p>

                                        <input type="submit" value="UPLOAD"/>
                                    </form>
                                
                                
                            </div>
                           
       
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        
        
   
        <footer class="htc__foooter__area gray-bg">
            <div class="container">
                
               
                <div class="htc__copyright__area">
                    <div class="row">
                        <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                            <div class="copyright__inner">
                                <div class="copyright">
                                    <p>© 2021 <a href="#">Cotisse MADAGASCAR / 034 85 397 76.</a>
                                    </p>
                                </div>
                                <ul class="footer__menu">
                                    <li><a href="DeconnexionAdmin">DeconnexionAdmin</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
             
            </div>
        </footer>
 
    </div>


    <script src="js/vendor/jquery-1.12.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/main.js"></script>

</body>

</html>

<% }else{ %>

<jsp:forward page="/loginAdmin.jsp"/>
    
<% } %>
