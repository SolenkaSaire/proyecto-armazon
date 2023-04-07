insert into ciudad values ("1","Calarca");
insert into ciudad values ("2","Pereira");
insert into ciudad values ("3","Tebaida");
insert into ciudad values ("4","Circacia");
insert into ciudad values ("5","Armenia");

insert into usuario () values ("1", "anderson@gmail.com","contraseña","Peña","avenida pepito","Anderson","3193192323");
insert into usuario () values ("2", "felipe@gmail.com","contra123","Amaya","avenida lujuria","Felipe","3202342121");
insert into usuario () values ("3", "sol@gmail.com","solesito","Torres","avenida luna","Solenka","3129632735");
insert into usuario () values ("4", "camilo@gmail.com","camilin","Vargas","avenida flores","Camilo","3182730914");
insert into usuario () values ("5", "diego@gmail.com","uchihaMadara","Peralta","avenida goku","Diego","3189231231");

insert into producto values ("1","Carro");
insert into producto values ("2","Moto");
insert into producto values ("3","Xbox One");
insert into producto values ("4","Play 5");
insert into producto values ("5","terreneitor");

insert into comentario values ("1","2","7/7/20","Me gusto pero le hace falta llantas",1,1);
insert into comentario values ("2","4","2/3/21","Me gusto pero no puedo montar a las motomamis",2,1);
insert into comentario values ("3","3","7/5/22","Me gusto pero no viene con controles",3,3);
insert into comentario values ("4","3","6/1/22","Me gusto pero el plus es carisimo",4,5);
insert into comentario values ("5","5","18/9/02","TERRENEITOR, el coche mas poderoso que ha existido",5,5);

insert into compra values ("1","7/7/20",1,"22.250",1);
insert into compra values ("2","2/6/20",1,"90.250",1);
insert into compra values ("3","3/4/22",1,"122.250",3);
insert into compra values ("4","5/3/20",1,"232.250",5);
insert into compra values ("5","1/2/22",1,"423.250",5);

insert into publicacion_producto values ("1","El carro de Toreto",13,1,2/1/1,12/12/12,2/3/1,475455000,4.5,1,1);
insert into publicacion_producto values ("2","Moto FZ 250",5,1,2/12/16,12/8/12,2/3/1,765455000,5,2,1);
insert into publicacion_producto values ("3","La consola mas economica del mercado",6,2,2/11/11,12/11/12,2/6/1,1255000,4,3,3);
insert into publicacion_producto values ("4","El plus sigue siendo caro...",4,2,2/6/12,12/5/12,2/7/1,3455000,2,4,5);
insert into publicacion_producto values ("5","TERRENEITOR, el coche mas poderoso que ha existido, con traccion 4X4 y 2 turbo motores",2,1,11/1/13,12/6/12,2/9/1,1000,5,5,5);

insert into detalle_compra values ("1",475455000,13,1,1);
insert into detalle_compra values ("2",765455000,5,2,2);
insert into detalle_compra values ("3",1255000,6,3,3);
insert into detalle_compra values ("4",3455000,4,4,4);
insert into detalle_compra values ("5",1000,2,5,5);

insert into moderador values ("1","admin1@hotmail.com","admin1");
insert into moderador values ("2","admin2@hotmail.com","admin2");
insert into moderador values ("3","admin3@hotmail.com","admin3");
insert into moderador values ("4","admin4@hotmail.com","admin4");
insert into moderador values ("5","admin5@hotmail.com","admin5");

insert into producto_categoria values ("1","Transporte");
insert into producto_categoria values ("2","Transporte");
insert into producto_categoria values ("3","Juegos");
insert into producto_categoria values ("4","Juegos");
insert into producto_categoria values ("5","TERRENEITOR");

insert into producto_imagenes values ("1","imagen1");
insert into producto_imagenes values ("2","imagen2");
insert into producto_imagenes values ("3","imagen3");
insert into producto_imagenes values ("4","imagen4");
insert into producto_imagenes values ("5","imagen...TERRENEITOR");

insert into producto_moderador values ("1",2,"1/1/1","La imagen es sospechosa",1,1);
insert into producto_moderador values ("2",1,"1/12/1","Todo bien",1,2);
insert into producto_moderador values ("3",1,"1/3/1","Todo correcto",1,3);
insert into producto_moderador values ("4",2,"1/5/1","Y yo que me alegro",1,4);
insert into producto_moderador values ("5",1,"1/6/1","TERRENEITOR",1,5);

insert into publicacion_producto_ciudades values ("1","1");
insert into publicacion_producto_ciudades values ("2","1");
insert into publicacion_producto_ciudades values ("3","2");
insert into publicacion_producto_ciudades values ("4","3");
insert into publicacion_producto_ciudades values ("5","1");

insert into usuario_publicaciones_favoritas values ("1","1");
insert into usuario_publicaciones_favoritas values ("2","1");
insert into usuario_publicaciones_favoritas values ("3","2");
insert into usuario_publicaciones_favoritas values ("4","3");
insert into usuario_publicaciones_favoritas values ("5","1");
