<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script>
    $( function() {
      $( ".widget input[type=submit], .widget s, .widget button" ).button();
      $( "button, input, s" ).click( function( event ) {
        event.preventDefault();
      } );
    } );
    </script>   
    
    
    
    <div class="content-wrapper">
            <section class="content">
    <h1>Sistema de Ventas, disfrute este Sistema de ventas</h1>
         
  <br/>
  Mensaje: 
  ${message}
   <br/>
   
   <p> <spring:message code="welcome.greeting" arguments="${startMeeting}" /> </p> 
   <br/>
   Cantidad Registros: 
    <br/>
    
<!-- LEEEEMEEEE de ULISES  ACA ES DONDE SE VA PARA IR A Buscar  -->
    <form action="${pageContext.request.contextPath}/buscar" method="POST">
        <div class="card">
        <div class="card-body">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td> <input type="text" class="form-control"  id="dato" name="dato"/></td>
                    <td><input type="submit" value="Buscar" class="btn btn-primary"/>  </td>
                    <td><a class="btn btn-danger" href="${pageContext.request.contextPath}/formPersona">Nuevo</td> 
                </tr>
            </table> 
        </div>
        </div>

        
    </form>
    
    <c:if test="${!empty ListaDetalleVenta}">
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Cliente</th>
          <th scope="col">Numero</th>
          <th scope="col">Cantidad de Productos</th>
          
          
        </tr>
      </thead>
      <tbody>
          <c:forEach items="${ListaDetalleVenta}" var="dato">
                <tr>
                  <td>${dato.idDetalleVenta}</td>
                  <td>${dato.idVenta}</td>
                  <td>${dato.idProducto}</td>
                  <td>${dato.cantidad}</td>
                 
                </tr>
        </c:forEach> 
      </tbody>
    </table>   
    </c:if>
                </section>
               </div> 