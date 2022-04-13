<%-- 
    Document   : listeVoyageAdmin
    Created on : 4 août 2021, 17:01:19
    Author     : rindrarolando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="objects.*" %>
<%@page import="services.*" %>

<% 
    DestinationService service = new DestinationService();
    ArrayList<Destination> destinations = service.getDestinations();
    
     %>

    <% if(session.getAttribute("sessionAdmin") != null){ %>
        
    
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Voyages</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
   
    <link rel="shortcut icon" type="image/x-icon" href="images/cotisse.jpg">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    

   
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
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
                                    <li class="drop"><a href="acceuilAdmin.jsp">Acceuil</a></li>
                                    <li class="drop"><a href="listeVoyageAdmin.jsp">Liste Voyages</a></li>
                                    <li class="drop"><a href="upload.jsp">Upload Images</a></li>
                                   <li class="drop"><a href="listeReservations.jsp">Liste Reservations</a></li>
                                </ul>
                            </nav>
                            <div class="mobile-menu clearfix visible-xs visible-sm">
                                <nav id="mobile_dropdown">
                                    <ul>
                                    <li class="drop"><a href="acceuilAdmin.jsp">Acceuil</a></li>
                                    <li class="drop"><a href="listeVoyageAdmin.jsp">Liste Voyages</a></li>
                                    <li class="drop"><a href="upload.jsp">Upload Images</a></li>
                                    <li class="drop"><a href="listeReservations.jsp">Liste Reservations</a></li>
                                    </ul>
                                </nav>
                            </div>                         
                        </div>

                        <div class="col-md-2 col-sm-4 col-xs-3">  
                            <ul class="menu-extra"><li class="search search__open hidden-xs"><span class="ti-search"></span></li></ul>
                        </div>
                    </div>
                    <div class="mobile-menu-area"></div>
                </div>
            </div>
            
        </header>

        <div class="body__overlay"></div>

        <div class="ht__bradcaump__area" style="background: rgba(0, 0, 0, 0) url(images/bg/2.jpg) no-repeat scroll center center / cover ;">
            <div class="ht__bradcaump__wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">Liste des voyages</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="#">Cotisse & Co</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Madagascar</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row" style="text-align: center; ">
            <%
                String message =(String)request.getAttribute("message") ;
                if(message!=null){ %>
                    <div class="alert alert-success" role="alert">
                        <%= message %>
                    </div>
                <% } %>
        </div>
        
        <div class="row" style="text-align: center; ">
            <%
                String messageModif =(String)request.getAttribute("messageModification") ;
                if(messageModif!=null){ %>
                    <div class="alert alert-success" role="alert">
                        <%= messageModif %>
                    </div>
                <% } %>
        </div>

        <section class="htc__product__area shop__page ptb--130 bg__white">
            <div class="container">
                <div class="htc__product__container">
                    <div class="row">
                        <div class="col-md-12">

                            <div class="wishlist-area ptb--120 bg__white">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12 col-xs-12">
                                            <div class="wishlist-content">
                                                <form action="#">
                                                    <div class="wishlist-table table-responsive">

                                                    <table>
                                                            <thead>
                                                                <tr>
                                                                    <th class="product-remove"><span class="nobr">Retirer Voyage</span></th>
                                                                    <th class="product-name"><span class="nobr">Itinéraire</span></th>
                                                                    <th class="product-name"><span class="nobr">Modifier</span></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <% for (int i = 0; i< destinations.size(); i++) { 
                                                                %>
                                                                  
                                                                <tr>
                                                                    <td class="product-remove"><a href="SupprimerVoyage?id=<%= destinations.get(i).getIdDestination() %>">×</a></td>
                                                                    <td class="product-name"><%= destinations.get(i).getDescription() %></td>
                                                                    <td class="product-name"><a href="modifierAdmin.jsp?id=<%= destinations.get(i).getIdDestination() %>">Modifier</a></td>
                                                                    
                                                                </tr>
                                                                <% } 
                                                                %>
                                                            </tbody>
                                                    </table>

                                                    </div>  
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
      
                    <div class="row mt--60">
                        <div class="col-md-12">
                            <div class="htc__loadmore__btn">
                                
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </section>

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
                                    <li><a href="DeconnexionAdmin">Se Déconnecter</a></li>
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