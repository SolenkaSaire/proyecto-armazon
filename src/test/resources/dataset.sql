

insert into usuario () values (1, "anderson@gmail.com","contraseña","Peña","avenida pepito","Anderson","3193192323");
insert into usuario () values (2, "felipe@gmail.com","contra123","Amaya","avenida lujuria","Felipe","3202342121");
insert into usuario () values (3, "sol@gmail.com","solesito","Torres","avenida luna","Solenka","3129632735");
insert into usuario () values (4, "camilo@gmail.com","camilin","Vargas","avenida flores","Camilo","3182730914");
insert into usuario () values (5, "diego@gmail.com","uchihaMadara","Peralta","avenida goku","Diego","3189231231");

insert into producto values (1,"Carro");
insert into producto values (2,"Moto");
insert into producto values (3,"Xbox One");
insert into producto values (4,"Play 5");
insert into producto values (5,"terreneitor");

insert into publicacion_producto values (1,"El carro de Toreto",13,1,"2015-11-01 14:40:25","2015-11-01 14:40:25","2015-11-01 14:40:25",100000,0,1,1);
insert into publicacion_producto values (2,"Moto FZ 250",5,1,"2015-11-01 14:40:25","2015-11-01 14:40:25","2015-11-01 14:40:25",150000,5,1,1);
insert into publicacion_producto values (3,"La consola mas economica del mercado",6,1,"2012-11-01 14:40:25","2011-11-01 14:40:25","2015-11-01 14:40:25",125000,4,1,1);
insert into publicacion_producto values (4,"El plus sigue siendo caro...",4,1,"2012-11-01 14:40:25","2013-11-01 14:40:25","2014-11-01 14:40:25",134000,2,4,4);
insert into publicacion_producto values (5,"TERRENEITOR rojo basico, el coche basico , con traccion 4X4 y 2 turbo motores",2,1,"2018-11-01 14:40:25","2017-11-01 14:40:25","2016-11-01 14:40:25",115000,5,5,5);


insert into comentario values (1,2,"2020-10-01 12:24:25","Me gusto pero le hace falta llantas",1,1);
insert into comentario values (2,4,"2019-10-01 12:24:25","Me gusto pero no puedo montar a las motomamis",2,1);
insert into comentario values (3,3,"2018-10-01 16:24:25","Me gusto pero no viene con controles",3,3);
insert into comentario values (4,3,"2010-10-01 18:24:25","Me gusto pero el plus es carisimo",4,5);
insert into comentario values (5,5,"2012-10-01 14:24:25","TERRENEITOR, el coche mas poderoso que ha existido",5,5);

insert into compra values (1,"2020-10-01 12:24:25",1,22.250,1);
insert into compra values (2,"2021-10-01 12:24:25",1,90.250,1);
insert into compra values (3,"2020-5-01 12:24:25",1,122.250,3);
insert into compra values (4,"2020-4-01 12:24:25",1,232.250,5);
insert into compra values (5,"2018-6-01 12:24:25",1,423.250,5);

insert into detalle_compra values (1,475455000,13,1,1);
insert into detalle_compra values (1,765455000,5,2,2);
insert into detalle_compra values (3,1255000,6,3,3);
insert into detalle_compra values (4,3455000,4,4,4);
insert into detalle_compra values (5,1000,2,5,5);
insert into detalle_compra values (6,100000,3,1,1);

insert into moderador values (1,"admin1@hotmail.com","admin1");
insert into moderador values (2,"admin2@hotmail.com","admin2");
insert into moderador values (3,"admin3@hotmail.com","admin3");
insert into moderador values (4,"admin4@hotmail.com","admin4");
insert into moderador values (5,"admin5@hotmail.com","admin5");

insert into producto_categoria values (1,"HERRAMIENTAS");
insert into producto_categoria values (2,"PINTURA");
insert into producto_categoria values (3,"HOGAR");
insert into producto_categoria values (4,"TECNOLOGIA");
insert into producto_categoria values (5,"COCHES");

insert into producto_ciudad values (1,"ARMENIA");
insert into producto_ciudad values (2,"BARRANCABERMEJA");
insert into producto_ciudad values (3,"BARRANQUILLA");
insert into producto_ciudad values (4,"BOGOTA");
insert into producto_ciudad values (5,"BUCARAMANGA");

insert into producto_imagenes values (1,"imagen1");
insert into producto_imagenes values (2,"imagen2");
insert into producto_imagenes values (3,"imagen3");
insert into producto_imagenes values (4,"imagen4");
insert into producto_imagenes values (5,"imagen...TERRENEITOR");

insert into producto_moderador values (1,2,"2015-11-01 16:40:25","La imagen es sospechosa",1,1);
insert into producto_moderador values (2,1,"2014-11-01 15:40:25","Todo bien",1,2);
insert into producto_moderador values (3,1,"2013-11-01 14:40:25","Todo correcto",1,3);
insert into producto_moderador values (4,2,"2012-11-01 13:40:25","Y yo que me alegro",1,4);
insert into producto_moderador values (5,1,"2011-11-01 12:40:25","TERRENEITOR",1,5);


insert into usuario_publicaciones_favoritas values (1,1);
insert into usuario_publicaciones_favoritas values (1,2);
insert into usuario_publicaciones_favoritas values (1,3);