package restful.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author odpinerosh
 */

@XmlRootElement
public class ProductosModel {
    private int id_prod;
    private String nombre_prod;
    private String desc_prod;
    private int id_categoria;
    private String url_img_prod;
    private float precio_prod;
    private String disp_prod;
    private String estado_prod;

    public ProductosModel() {
    }

    public ProductosModel(int id_prod, String nombre_prod, String desc_prod, int id_categoria, String url_img_prod, float precio_prod, String disp_prod, String estado_prod) {
        this.id_prod = id_prod;
        this.nombre_prod = nombre_prod;
        this.desc_prod = desc_prod;
        this.id_categoria = id_categoria;
        this.url_img_prod = url_img_prod;
        this.precio_prod = precio_prod;
        this.disp_prod = disp_prod;
        this.estado_prod = estado_prod;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getDesc_prod() {
        return desc_prod;
    }

    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getUrl_img_prod() {
        return url_img_prod;
    }

    public void setUrl_img_prod(String url_img_prod) {
        this.url_img_prod = url_img_prod;
    }

    public float getPrecio_prod() {
        return precio_prod;
    }

    public void setPrecio_prod(float precio_prod) {
        this.precio_prod = precio_prod;
    }

    public String getDisp_prod() {
        return disp_prod;
    }

    public void setDisp_prod(String disp_prod) {
        this.disp_prod = disp_prod;
    }

    public String getEstado_prod() {
        return estado_prod;
    }

    public void setEstado_prod(String estado_prod) {
        this.estado_prod = estado_prod;
    }
    
    
}
