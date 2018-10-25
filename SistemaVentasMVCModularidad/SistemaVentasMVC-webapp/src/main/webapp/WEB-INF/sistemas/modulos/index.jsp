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
                <!-- Content Wrapper. Contains page content -->
    
    <h1>Buen dia, disfrute este Sistema de ventas</h1>
    <br/>
    <a href="/pers" class="btn btn-warning">Ir Persona</a>

    <button class="ui-button ui-widget ui-corner-all">A button element</button>

    <input class="ui-button ui-widget ui-corner-all" type="submit" value="A submit button">

    <a class="ui-button ui-widget ui-corner-all" href="#">An anchor</a>  
        
  <button class="btn waves-effect waves-light" type="submit" name="action">Submit
    <i class="material-icons right">send</i>
  </button>       
  <br/>
  Mensaje: 
  ${message}
   <br/>
   
   <p> <spring:message code="welcome.greeting" arguments="${startMeeting}" /> </p> 
   <br/>
   Cantidad Registros: 
    <br/>
    <form action="${pageContext.request.contextPath}/buscar" method="POST">
        <div class="card">
        <div class="card-body">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td> <input type="text" class="form-control"  id="dato" name="dato"/></td>
                    <td><input type="submit" value="Buscar" class="btn btn-primary"/>  </td>
                    <td><input type="button" value="Nuevo" class="btn btn-danger"/>  </td> 
                </tr>
            </table> 
        </div>
        </div>

        
    </form>
    
    <c:if test="${!empty ListaPersona}">
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th scope="col">#</th>
          <th scope="col">Nombres</th>
          <th scope="col">Apellidos</th>
          
          <th scope="col">Telefono</th>
          <th scope="col">Direccion</th>
          <th scope="col">Email</th>
          <th scope="col">Dni</th>
          <th scope="col">Opciones</th>
          
        </tr>
      </thead>
      <tbody>
          <c:forEach items="${ListaPersona}" var="dato">
                <tr>
                  <td>${dato.idPersona}</td>
                  <td>${dato.nombres}</td>
                  <td>${dato.apellidos}</td>
                  
                  <td>${dato.telefono}</td>
                  <td>${dato.direccion}</td>
                  <td>${dato.email}</td>
                  <td>${dato.dni}</td>
                  <td><a href="${pageContext.request.contextPath}/elim?id=${dato.idPersona}">E</a></td>
                </tr>
        </c:forEach> 
      </tbody>
    </table>   
    </c:if>
        