package co.edu.uniquindio.proyecto.servicios.implementacion;

import co.edu.uniquindio.proyecto.dto.ProductoDTO;
import co.edu.uniquindio.proyecto.dto.ProductoGetDTO;
//import co.edu.uniquindio.proyecto.modelo.Activo;
import co.edu.uniquindio.proyecto.modelo.*;
import co.edu.uniquindio.proyecto.repositorios.ProductoRepo;
import co.edu.uniquindio.proyecto.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.proyecto.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImpl implements ProductoServicio {

    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setCategoria(productoDTO.getCategorias());
        producto.setImagenes(productoDTO.getImagenes());
        producto.setCiudad(productoDTO.getCiudades());

        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public int actualizarProducto(int codigoProducto, ProductoDTO productoDTO) throws Exception{
        /**
         * TODO Validar que exista publicacion
         */
        validarExiste(codigoProducto);
        Producto producto = convertir(productoDTO);
        producto.setCodigo(codigoProducto);
        return productoRepo.save(producto).getCodigo();
    }

    private Producto convertir(ProductoDTO productoDTO) throws Exception {
        //convertir publicacion
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setCategoria(productoDTO.getCategorias());
        producto.setImagenes(productoDTO.getImagenes());
        return producto;
    }

    @Override
    public int actualizarUnidades(int codigoProducto, int unidades) throws Exception{
        Producto producto= obtenerProductoP(codigoProducto);

        for (PublicacionProducto p :producto.getPublicacionProductos() ) {
            if (producto.getCodigo() == codigoProducto) {
                p.setDisponibilidad(unidades);
                break;
            }
        }
        return productoRepo.save(producto).getCodigo();
    }

    @Override
    public ProductoGetDTO obtenerProducto(int codigoProducto) throws Exception{
        return convertir( obtenerProductoP(codigoProducto) );
    }

    @Override
    public Producto obtenerProductoP(int codigoProducto) throws Exception{
        Optional<Producto> producto = productoRepo.findById(codigoProducto);

        if(producto.isEmpty() ){
            throw new Exception("El código "+codigoProducto+" no está asociado a ningún producto");
        }

        return producto.get();
    }

    private ProductoGetDTO convertir(Producto producto){
        ProductoGetDTO productoGetDTO = new ProductoGetDTO(
                producto.getNombre(),
                convertirCategoria(producto.getCategoria()),
                producto.getImagenes(),
                convertirPublicaciones( producto.getPublicacionProductos() ),
                convertirCiudades(producto.getCiudad()));

        return productoGetDTO;
    }

    @Override
    public List<Integer> convertirPublicaciones(List<PublicacionProducto> publicaciones) {
        List<Integer> listaPublicacion = new ArrayList<>();
        for (PublicacionProducto pub: publicaciones) {
            listaPublicacion.add(pub.getCodigo());
        }
        return listaPublicacion;
    }
    @Override
    public List<String> convertirCategoria(List<Categoria> categorias) {
        List<String> listaCategoria = new ArrayList<>();
        for (Categoria categoria: categorias) {
            listaCategoria.add(String.valueOf(categoria));
        }
        return listaCategoria;
    }

    @Override
    public List<String> convertirCiudades(List<Ciudad> ciudades) {
        List<String> listaCiudad = new ArrayList<>();
        for (Ciudad ciudad: ciudades) {
            listaCiudad.add(String.valueOf(ciudad));
        }
        return listaCiudad;
    }

    public void validarExiste(int codigoProducto) {
        boolean existe = productoRepo.existsById(codigoProducto);
        if (!existe){
            try {
                throw new Exception("El código "+codigoProducto+" no está asociado a ningun producto");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public List<Categoria> listarCategorias() throws Exception {
        //System.out.println("categorias"+Arrays.asList(Categoria.values()).toString());
        return new ArrayList<>(Arrays.asList(Categoria.values()));

    }

    @Override
    public List<Ciudad> listarCiudades() throws Exception {
        return new ArrayList<>(Arrays.asList(Ciudad.values()));
    }

}