package ucr.casoUso;

import com.sebworks.vaadstrap.Col;
import com.sebworks.vaadstrap.ColMod;
import com.sebworks.vaadstrap.ColOffsetMod;
import com.sebworks.vaadstrap.Container;
import com.sebworks.vaadstrap.MarginMod;
import com.sebworks.vaadstrap.Row;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;

public class VistaCambioPassword extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Accordion accordion_1;
	@AutoGenerated
	private Label labelErrorActualizando;
	@AutoGenerated
	private Label labelExito;
	@AutoGenerated
	private Label labelErrorPassConf;
	@AutoGenerated
	private Label labelErrorPassViejo;
	@AutoGenerated
	private Label labelPassConf;
	@AutoGenerated
	private Label labelPassNuevo;
	@AutoGenerated
	private Label labelPassViejo;
	@AutoGenerated
	private Label labelTitulo;
	@AutoGenerated
	private Button botonVolverCancelar;
	@AutoGenerated
	private Button botonCambiar;
	@AutoGenerated
	private PasswordField passFieldConf;
	@AutoGenerated
	private PasswordField passFieldNuevo;
	@AutoGenerated
	private PasswordField passFieldViejo;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public VistaCambioPassword() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		Controlador control = Controlador.obtenerInstancia();
		ModeloCambioPassword modelo = ModeloCambioPassword.obtenerInstancia();
		labelErrorPassConf.setVisible(false);
		labelErrorPassViejo.setVisible(false);
		labelExito.setVisible(false);
		labelErrorActualizando.setVisible(false);
		// TODO add user code here
		botonVolverCancelar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				control.cambiarVista("Menu Principal");
			}
		});
		botonCambiar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				labelErrorPassConf.setVisible(false);
				labelErrorPassViejo.setVisible(false);
				labelExito.setVisible(false);
				labelErrorActualizando.setVisible(false);
				if(modelo.autenticar(control.getCedulaUsuario(), passFieldViejo.getValue())){
					if(modelo.comparar(passFieldNuevo.getValue(), passFieldConf.getValue())){
						if(modelo.actualizarPass(control.getCedulaUsuario(), passFieldNuevo.getValue()))
							labelExito.setVisible(true);
						else
							labelErrorActualizando.setVisible(true);
					}
					else
						labelErrorPassConf.setVisible(true);
				}
				else
					labelErrorPassViejo.setVisible(true);
			}
		});
	}
	
	public void setVista() {
		
		this.setSizeFull();
		mainLayout.removeAllComponents();
		
		Container container = new Container();
		
		Row row = container.addRow();
		Col col1 = row.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2);
		col1.addComponent(labelTitulo);
		
		Row row1 = container.addRow();
		Col col2 = row1.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP30);
		col2.addComponent(labelPassViejo);
		Col col3 = row1.addCol(ColMod.XS_12, ColMod.SM_4, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP20);
		col3.addComponent(passFieldViejo);
		Col col4 = row1.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP30);
		col4.addComponent(labelPassNuevo);
		Col col5 = row1.addCol(ColMod.XS_12, ColMod.SM_4, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP20);
		col5.addComponent(passFieldNuevo);
		Col col6 = row1.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP30);
		col6.addComponent(labelPassConf);
		Col col7 = row1.addCol(ColMod.XS_12, ColMod.SM_4, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP20);
		col7.addComponent(passFieldConf);
		
		Row row2 = container.addRow();
		Col col12 = row2.addCol(ColMod.XS_12, ColMod.SM_3, ColMod.MD_2, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP30);
		col12.addComponent(botonCambiar);
		Col col13 = row2.addCol(ColMod.XS_12, ColMod.SM_3, ColOffsetMod.SM_OFFSET_1, ColMod.MD_2, MarginMod.TOP30);
		col13.addComponent(botonVolverCancelar);
		
		Row row3 = container.addRow();
		Col col8 = row3.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP10);
		col8.addComponent(labelErrorPassViejo);
		Col col9 = row3.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP10);
		col9.addComponent(labelErrorPassConf);
		Col col10 = row3.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP10);
		col10.addComponent(labelErrorActualizando);
		Col col11 = row3.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP10);
		col11.addComponent(labelExito);
		
		mainLayout.addComponent(container);
		
		MyUI.getCurrent().setContent(this);
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setStyleName("layout-cambiopass");
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// passFieldViejo
		passFieldViejo = new PasswordField();
		passFieldViejo.setImmediate(false);
		passFieldViejo.setWidth("-1px");
		passFieldViejo.setHeight("-1px");
		mainLayout.addComponent(passFieldViejo, "top:140.0px;left:40.0px;");
		
		// passFieldNuevo
		passFieldNuevo = new PasswordField();
		passFieldNuevo.setImmediate(false);
		passFieldNuevo.setWidth("-1px");
		passFieldNuevo.setHeight("-1px");
		mainLayout.addComponent(passFieldNuevo, "top:216.0px;left:40.0px;");
		
		// passFieldConf
		passFieldConf = new PasswordField();
		passFieldConf.setImmediate(false);
		passFieldConf.setWidth("-1px");
		passFieldConf.setHeight("-1px");
		mainLayout.addComponent(passFieldConf, "top:296.0px;left:40.0px;");
		
		// botonCambiar
		botonCambiar = new Button();
		botonCambiar.setCaption("Cambiar");
		botonCambiar.setImmediate(true);
		botonCambiar.setDescription("Cambiar");
		botonCambiar.setWidth("-1px");
		botonCambiar.setHeight("-1px");
		mainLayout.addComponent(botonCambiar, "top:360.0px;left:40.0px;");
		
		// botonVolverCancelar
		botonVolverCancelar = new Button();
		botonVolverCancelar.setCaption("Cancelar");
		botonVolverCancelar.setImmediate(true);
		botonVolverCancelar.setWidth("-1px");
		botonVolverCancelar.setHeight("-1px");
		mainLayout.addComponent(botonVolverCancelar, "top:360.0px;left:140.0px;");
		
		// labelTitulo
		labelTitulo = new Label();
		labelTitulo.setStyleName("titulo");
		labelTitulo.setImmediate(false);
		labelTitulo.setWidth("-1px");
		labelTitulo.setHeight("-1px");
		labelTitulo.setValue("Cambio de contraseña");
		mainLayout.addComponent(labelTitulo, "top:20.0px;left:40.0px;");
		
		// labelPassViejo
		labelPassViejo = new Label();
		labelPassViejo.setImmediate(false);
		labelPassViejo.setWidth("-1px");
		labelPassViejo.setHeight("-1px");
		labelPassViejo.setValue("Contraseña actual:");
		mainLayout.addComponent(labelPassViejo, "top:102.0px;left:40.0px;");
		
		// labelPassNuevo
		labelPassNuevo = new Label();
		labelPassNuevo.setImmediate(false);
		labelPassNuevo.setWidth("-1px");
		labelPassNuevo.setHeight("-1px");
		labelPassNuevo.setValue("Contraseña nueva:");
		mainLayout.addComponent(labelPassNuevo, "top:182.0px;left:40.0px;");
		
		// labelPassConf
		labelPassConf = new Label();
		labelPassConf.setImmediate(false);
		labelPassConf.setWidth("-1px");
		labelPassConf.setHeight("-1px");
		labelPassConf.setValue("Confirmar contraseña nueva:");
		mainLayout.addComponent(labelPassConf, "top:262.0px;left:40.0px;");
		
		// labelErrorPassViejo
		labelErrorPassViejo = new Label();
		labelErrorPassViejo.setStyleName("error");
		labelErrorPassViejo.setImmediate(false);
		labelErrorPassViejo.setWidth("-1px");
		labelErrorPassViejo.setHeight("-1px");
		labelErrorPassViejo.setValue("Contraseña actual invalida!");
		mainLayout.addComponent(labelErrorPassViejo, "top:402.0px;left:40.0px;");
		
		// labelErrorPassConf
		labelErrorPassConf = new Label();
		labelErrorPassConf.setStyleName("error");
		labelErrorPassConf.setImmediate(false);
		labelErrorPassConf.setWidth("-1px");
		labelErrorPassConf.setHeight("-1px");
		labelErrorPassConf.setValue("Contraseñas nuevas no coinciden!");
		mainLayout.addComponent(labelErrorPassConf, "top:402.0px;left:40.0px;");
		
		// labelExito
		labelExito = new Label();
		labelExito.setStyleName("exito");
		labelExito.setImmediate(false);
		labelExito.setWidth("-1px");
		labelExito.setHeight("-1px");
		labelExito.setValue("Contraseña actualizada exitosamente!");
		mainLayout.addComponent(labelExito, "top:402.0px;left:40.0px;");
		
		// labelErrorActualizando
		labelErrorActualizando = new Label();
		labelErrorActualizando.setStyleName("error");
		labelErrorActualizando.setImmediate(false);
		labelErrorActualizando.setWidth("-1px");
		labelErrorActualizando.setHeight("-1px");
		labelErrorActualizando.setValue("Error al actualizar la contraseña, por favor intente de nuevo.");
		mainLayout.addComponent(labelErrorActualizando, "top:402.0px;left:40.0px;");
		
		// accordion_1
		accordion_1 = new Accordion();
		accordion_1.setImmediate(false);
		accordion_1.setWidth("-1px");
		accordion_1.setHeight("-1px");
		mainLayout.addComponent(accordion_1);
		
		return mainLayout;
	}

}
