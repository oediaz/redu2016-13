package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.ExaminacionFacade;
import com.susolabs.redu.modelo.entidades.Examinacion;
import com.susolabs.redu.controlador.util.JsfUtil;
import com.susolabs.redu.controlador.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("examinacionController")
@SessionScoped
public class ExaminacionController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.ExaminacionFacade ejbFacade;
    private List<Examinacion> items = null;
    private Examinacion selected;
    private List<Examinacion> seleccion;

    public ExaminacionController() {
    }

    public List<Examinacion> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Examinacion> seleccion) {
        this.seleccion = seleccion;
    }
    
    

    public Examinacion getSelected() {
        return selected;
    }

    public void setSelected(Examinacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getExaminacionPK().setIdtrtamientocm(selected.getTratamientocancermama().getIdtrtamientocm());
    }

    protected void initializeEmbeddableKey() {
        selected.setExaminacionPK(new com.susolabs.redu.modelo.entidades.ExaminacionPK());
    }

    private ExaminacionFacade getFacade() {
        return ejbFacade;
    }

    public Examinacion prepareCreate() {
        selected = new Examinacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ExaminacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ExaminacionUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ExaminacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Examinacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Examinacion getExaminacion(com.susolabs.redu.modelo.entidades.ExaminacionPK id) {
        return getFacade().find(id);
    }

    public List<Examinacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Examinacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Examinacion.class)
    public static class ExaminacionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ExaminacionController controller = (ExaminacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "examinacionController");
            return controller.getExaminacion(getKey(value));
        }

        com.susolabs.redu.modelo.entidades.ExaminacionPK getKey(String value) {
            com.susolabs.redu.modelo.entidades.ExaminacionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.susolabs.redu.modelo.entidades.ExaminacionPK();
            key.setIdtrtamientocm(Integer.parseInt(values[0]));
            key.setIdexaminacion(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.susolabs.redu.modelo.entidades.ExaminacionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdtrtamientocm());
            sb.append(SEPARATOR);
            sb.append(value.getIdexaminacion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Examinacion) {
                Examinacion o = (Examinacion) object;
                return getStringKey(o.getExaminacionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Examinacion.class.getName()});
                return null;
            }
        }

    }

}