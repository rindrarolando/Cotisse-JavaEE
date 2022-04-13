<%-- 
    Document   : listeVoyageClient
    Created on : 2 août 2021, 19:22:39
    Author     : rindrarolando
--%>
<%@page import="java.sql.*" %>
<%@page import="services.*" %>
<%@page import="objects.*" %>
<%@page import="java.util.*" %>
<%
    Client cli = (Client) session.getAttribute("session");
    
%>

<% if(session.getAttribute("session") != null){ %>
        
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Listes des voyages reservés</title>
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
                                    <li class="drop"><a href="PaginationServlet">Acceuil</a></li>
                                    <li class="drop"><a href="listeVoyageClient.jsp">Liste des voyages reservés</a></li>
                                    
                                </ul>
                            </nav>
                            <div class="mobile-menu clearfix visible-xs visible-sm">
                                <nav id="mobile_dropdown">
                                    <ul>
                                    <li class="drop"><a href="PaginationServlet">Acceuil</a></li>
                                    <li class="drop"><a href="listeVoyageClient.jsp">Liste des Voyages reservés</a></li>
                                    
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
                                <h2 class="bradcaump-title">Les voyages que vous avez reservé.</h2>
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
                String message =(String)request.getAttribute("messageModification") ;
                if(message!=null){ %>
                    <div class="alert alert-success" role="alert">
                        <%= message %>
                    </div>
                <% } %>
        </div>
        
        <div class="row" style="text-align: center; ">
            <%
                String messageAnnulation =(String)request.getAttribute("messageAnnulation") ;
                if(messageAnnulation!=null){ %>
                    <div class="alert alert-success" role="alert">
                        <%= messageAnnulation %>
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
                                                                    <th class="product-name"><span class="nobr">Itinéraire</span></th>
                                                                    <th class="product-name"><span class="nobr">Pour</span></th>
                                                                    <th class="product-name"><span class="nobr">Date</span></th>
                                                                    <th class="product-name"><span class="nobr"></span></th>
                                                                    <th class="product-name"><span class="nobr"></span></th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <% 
                                                                    Class.forName("com.mysql.jdbc.Driver");
                                                                    Connection c = null;
                                                                    java.sql.Statement stmt = null;
                                                                    ResultSet res;

                                                                    String req ="SELECT * FROM reservation AS r JOIN destination as d ON r.iddestination=d.iddestination WHERE idclient='"+cli.getIdClient()+"' AND statut=TRUE;";

                                                                    try{
                                                                        c= DriverManager.getConnection("jdbc:mysql://localhost:3306/cotisse","root","root");
                                                                        stmt = c.createStatement();
                                                                        res = stmt.executeQuery(req);
                                                                        while(res.next()){ %>
                                                                            <tr>
                                                                                <td class="product-name"><%= res.getString("description") %></a></td>
                                                                                <td class="product-name"><%= res.getInt("places") %></td>
                                                                                <td class="product-name"><%= res.getDate("datereservation") %></td>
                                                                                <td class="product-remove"><a href="AnnulerReservation?id=<%=res.getInt("idreservation")%>">annuler</a></td>
                                                                                <td class="product-remove"><a href="modifierReservation.jsp?id=<%=res.getInt("idreservation")%>">modifier</a></td>
                                                                             </tr>
                                                                        <% }

                                                                    } catch (Exception e) {
                                                                        e.printStackTrace();
                                                                    }finally{
                                                                        if(c!=null){
                                                                            c.close();
                                                                        }
                                                                        if(stmt!=null){
                                                                            stmt.close();
                                                                        }
                                                                    }
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
                                    <li><a href="Deconnexion">Se Déconnecter</a></li>
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
<jsp:forward page="/index.jsp"/>
    
    <% } %>