package ucr.casoUso;

import java.util.ArrayList;

import com.sebworks.vaadstrap.Col;
import com.sebworks.vaadstrap.ColMod;
import com.sebworks.vaadstrap.ColOffsetMod;
import com.sebworks.vaadstrap.Container;
import com.sebworks.vaadstrap.MarginMod;
import com.sebworks.vaadstrap.Row;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.Item;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;

public class VistaUsuarios extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Label labelInstrucciones;
	@AutoGenerated
	private Button botonInstructorCancel;
	@AutoGenerated
	private Button botonAceptar;
	@AutoGenerated
	private Label labelError;
	@AutoGenerated
	private Label labelExito;
	@AutoGenerated
	private Label labelUsuario;
	@AutoGenerated
	private Label labelUsuarioElim;
	@AutoGenerated
	private Label labelInstructor;
	@AutoGenerated
	private Label labelInstructorConf;
	@AutoGenerated
	private Button botonInstructorElimCancel;
	@AutoGenerated
	private Button botonInstructorElimConf;
	@AutoGenerated
	private Button botonElimCancel;
	@AutoGenerated
	private Button botonElimConf;
	@AutoGenerated
	private Label labelElimConf2;
	@AutoGenerated
	private Label labelElimConf1;
	@AutoGenerated
	private Button botonCancelar;
	@AutoGenerated
	private Button botonEliminar;
	@AutoGenerated
	private Button botonInstructorElim;
	@AutoGenerated
	private Table tablaInstructor;
	@AutoGenerated
	private Table tablaUsuarios;
	@AutoGenerated
	private Label labelTitulo;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	
	Controlador control;
	ControladorUsuarios controlador;
	Object lineaUsuario;
	Item itemUsuario;
	Item itemInstructor;
	Object lineaInstructor;
	
	public VistaUsuarios() {
		buildMainLayout();
		setCompositionRoot(mainLayout);
		control = Controlador.obtenerInstancia();
		controlador = ControladorUsuarios.obtenerInstancia();
		
		labelExito.setVisible(false);
		labelError.setVisible(false);
		labelUsuario.setVisible(false);
		labelUsuarioElim.setVisible(false);
		labelInstructor.setVisible(false);
		labelElimConf1.setVisible(false);
		labelElimConf2.setVisible(false);
		labelInstructorConf.setVisible(false);
		botonElimConf.setVisible(false);
		botonElimCancel.setVisible(false);
		botonInstructorElimConf.setVisible(false);
		botonInstructorElimCancel.setVisible(false);
		tablaInstructor.setVisible(false);
		botonAceptar.setVisible(false);
		botonInstructorElim.setVisible(false);
		botonInstructorCancel.setVisible(false);
		labelInstrucciones.setVisible(false);
		
		tablaInstructor.setSelectable(true);
		tablaUsuarios.setSelectable(true);
		
		llenarTablaUsuarios(control.getCedulaUsuario());
		
		botonEliminar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				lineaUsuario = tablaUsuarios.getValue();
				itemUsuario = tablaUsuarios.getItem(lineaUsuario);
				String cedUsuario = itemUsuario.getItemProperty("Cédula").getValue().toString();
				if(itemUsuario.getItemProperty("Tipo de usuario").getValue().toString().compareTo("Instructor") == 0 || itemUsuario.getItemProperty("Tipo de usuario").getValue().toString().compareTo("Instructor Jefe") == 0) {
					llenarTablaInstructores(itemUsuario.getItemProperty("Cédula").getValue().toString());
					botonEliminar.setVisible(false);
					botonCancelar.setVisible(false);
					tablaUsuarios.setEnabled(false);
					tablaInstructor.setVisible(true);
					labelInstrucciones.setVisible(true);
					botonInstructorElim.setVisible(true);
					botonInstructorCancel.setVisible(true);
				}
				else {
					String usuario = itemUsuario.getItemProperty("Nombre").getValue().toString() + " ";
					usuario += itemUsuario.getItemProperty("Apellido").getValue().toString() + ", Ced. ";
					usuario += itemUsuario.getItemProperty("Cédula").getValue().toString();
					labelUsuario.setValue(usuario);
					tablaUsuarios.setVisible(false);
					botonEliminar.setVisible(false);
					botonCancelar.setVisible(false);
					labelUsuario.setVisible(true);
					labelUsuarioElim.setVisible(true);
					labelElimConf1.setVisible(true);
					labelElimConf2.setVisible(true);
					botonElimConf.setVisible(true);
					botonElimCancel.setVisible(true);
				}
			}
		});
		
		botonInstructorElimConf.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				lineaUsuario = tablaUsuarios.getValue();
				itemUsuario = tablaUsuarios.getItem(lineaUsuario);
				lineaInstructor = tablaInstructor.getValue();
				itemInstructor = tablaInstructor.getItem(lineaInstructor);
				labelInstructor.setVisible(false);
				labelUsuario.setVisible(false);
				labelUsuarioElim.setVisible(false);
				labelElimConf1.setVisible(false);
				labelElimConf2.setVisible(false);
				labelInstructorConf.setVisible(false);
				botonInstructorElimConf.setVisible(false);
				botonInstructorElimCancel.setVisible(false);
				if(controlador.asignarExpedientes(itemUsuario.getItemProperty("Cédula").getValue().toString() , itemInstructor.getItemProperty("Cédula").getValue().toString())) {
					if(controlador.eliminarUsuario(itemUsuario.getItemProperty("Cédula").getValue().toString()))
						labelExito.setVisible(true);
					else
						labelError.setVisible(true);
				}
				else
					labelError.setVisible(true);
				botonAceptar.setVisible(true);
				llenarTablaUsuarios(control.getCedulaUsuario());
			}
		});
		
		botonInstructorElim.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				lineaUsuario = tablaUsuarios.getValue();
				itemUsuario = tablaUsuarios.getItem(lineaUsuario);
				lineaInstructor = tablaInstructor.getValue();
				itemInstructor = tablaInstructor.getItem(lineaInstructor);
				tablaUsuarios.setVisible(false);
				tablaInstructor.setVisible(false);
				labelInstrucciones.setVisible(false);
				botonInstructorElim.setVisible(false);
				botonInstructorCancel.setVisible(false);
				String usuario = itemUsuario.getItemProperty("Nombre").getValue().toString() + " ";
				usuario += itemUsuario.getItemProperty("Apellido").getValue().toString() + ", Ced. ";
				usuario += itemUsuario.getItemProperty("Cédula").getValue().toString();
				String instructor = itemInstructor.getItemProperty("Nombre").getValue().toString() + " ";
				instructor += itemInstructor.getItemProperty("Apellido").getValue().toString() + ", Ced. ";
				instructor += itemInstructor.getItemProperty("Cédula").getValue().toString();
				labelUsuario.setValue(usuario);
				labelInstructor.setValue(instructor);
				labelInstructor.setVisible(true);
				labelUsuario.setVisible(true);
				labelUsuarioElim.setVisible(true);
				labelElimConf1.setVisible(true);
				labelElimConf2.setVisible(true);
				labelInstructorConf.setVisible(true);
				botonInstructorElimConf.setVisible(true);
				botonInstructorElimCancel.setVisible(true);
			}
		});
		
		botonElimConf.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				lineaUsuario = tablaUsuarios.getValue();
				itemUsuario = tablaUsuarios.getItem(lineaUsuario);
				labelUsuario.setVisible(false);
				labelUsuarioElim.setVisible(false);
				labelElimConf1.setVisible(false);
				labelElimConf2.setVisible(false);
				botonElimConf.setVisible(false);
				botonElimCancel.setVisible(false);
				
				botonAceptar.setVisible(true);
				if(controlador.eliminarUsuario(itemUsuario.getItemProperty("Cédula").getValue().toString()))
					labelExito.setVisible(true);
				else
					labelError.setVisible(true);
				llenarTablaUsuarios(control.getCedulaUsuario());
			}
		});
		
		botonAceptar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				control.cambiarVista("Eliminar Usuario");
			}
		});
		
		botonInstructorElimCancel.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				labelUsuario.setVisible(false);
				labelUsuarioElim.setVisible(false);
				labelInstructor.setVisible(false);
				labelElimConf1.setVisible(false);
				labelElimConf2.setVisible(false);
				labelInstructorConf.setVisible(false);
				botonInstructorElimConf.setVisible(false);
				botonInstructorElimCancel.setVisible(false);
				tablaUsuarios.setEnabled(true);
				tablaUsuarios.setVisible(true);
				botonEliminar.setVisible(true);
				botonCancelar.setVisible(true);
			}
		});
		
		botonInstructorCancel.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				tablaInstructor.setVisible(false);
				labelInstrucciones.setVisible(false);
				botonInstructorElim.setVisible(false);
				botonInstructorCancel.setVisible(false);
				tablaUsuarios.setEnabled(true);
				tablaUsuarios.setVisible(true);
				botonEliminar.setVisible(true);
				botonCancelar.setVisible(true);
			}
		});
		
		botonElimCancel.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				labelUsuario.setVisible(false);
				labelUsuarioElim.setVisible(false);
				labelElimConf1.setVisible(false);
				labelElimConf2.setVisible(false);
				botonElimConf.setVisible(false);
				botonElimCancel.setVisible(false);
				tablaUsuarios.setVisible(true);
				botonEliminar.setVisible(true);
				botonCancelar.setVisible(true);
			}
		});
		
		botonCancelar.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				control.cambiarVista("Menu Principal");
			}
		});
	}
	
	
	
	public void llenarTablaUsuarios(String cedUsuario){
		ArrayList<String[]> resultados = controlador.pedirDatosUsuarios(cedUsuario);
		tablaUsuarios.addContainerProperty("Cédula", String.class, null);
		tablaUsuarios.addContainerProperty("Nombre", String.class, null);
		tablaUsuarios.addContainerProperty("Apellido", String.class, null);
		tablaUsuarios.addContainerProperty("Tipo de usuario", String.class, null);
		for(int i = 0; i < resultados.size(); i++){
			String[] tupla = resultados.get(i);
			tablaUsuarios.addItem(new Object[]{tupla[0], tupla[1], tupla[2], tupla[3]}, (i +1));
		}
	}
	
	public void llenarTablaInstructores(String cedInst){
		ArrayList<String[]> resultados = controlador.pedirDatosInstructores(cedInst);
		tablaInstructor.addContainerProperty("Cédula", String.class, null);
		tablaInstructor.addContainerProperty("Nombre", String.class, null);
		tablaInstructor.addContainerProperty("Apellido", String.class, null);
		for(int i = 0; i < resultados.size(); i++){
			String[] tupla = resultados.get(i);
			tablaInstructor.addItem(new Object[]{tupla[0], tupla[1], tupla[2]}, (i +1));
		}
	}
	
	public void setVista() {
		
		this.setSizeFull();
		mainLayout.removeAllComponents();
		
		Container container = new Container();
		
		Row row1 = container.addRow();
		Col col1 = row1.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2);
		col1.addComponent(labelTitulo);
		
		Row row2 = container.addRow();
		Col col2 = row2.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP30);
		col2.addComponent(tablaUsuarios);
		
		Row row3 = container.addRow();
		Col col3 = row3.addCol(ColMod.XS_12, ColMod.SM_4, ColMod.MD_3, ColOffsetMod.MD_OFFSET_2);
		col3.addComponent(botonEliminar);
		Col col4 = row3.addCol(ColMod.XS_12, ColMod.SM_4, ColOffsetMod.SM_OFFSET_4, ColMod.MD_3, ColOffsetMod.MD_OFFSET_2);
		col4.addComponent(botonCancelar);
		
		Row row4 = container.addRow();
		Col col6 = row4.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2);
		col6.addComponent(labelInstrucciones);
		Col col5 = row4.addCol(ColMod.XS_12, ColMod.MD_8, ColOffsetMod.MD_OFFSET_2, MarginMod.TOP30);
		col5.addComponent(tablaInstructor);
		
		Row row5 = container.addRow();
		Col col7 = row5.addCol(ColMod.XS_12, ColMod.SM_4, ColMod.MD_3, ColOffsetMod.MD_OFFSET_2);
		col7.addComponent(botonInstructorElim);
		Col col8 = row5.addCol(ColMod.XS_12, ColMod.SM_4, ColOffsetMod.SM_OFFSET_4, ColMod.MD_3, ColOffsetMod.MD_OFFSET_2);
		col8.addComponent(botonInstructorCancel);
		
		Row row6 = container.addRow();
		row6.addStyleName("usuarios-confirmacion");
		Col col9 = row6.addCol(ColMod.XS_12, ColMod.MD_6, ColOffsetMod.MD_OFFSET_3);
		col9.addComponent(labelUsuarioElim);
		Col col10 = row6.addCol(ColMod.XS_12, ColMod.MD_6, ColOffsetMod.MD_OFFSET_3);
		col10.addComponent(labelUsuario);
		Col col11 = row6.addCol(ColMod.XS_12, ColMod.MD_6, ColOffsetMod.MD_OFFSET_3);
		col11.addComponent(labelElimConf1);
		Col col12 = row6.addCol(ColMod.XS_12, ColMod.MD_6, ColOffsetMod.MD_OFFSET_3);
		col12.addComponent(labelElimConf2);
		Col col13 = row6.addCol(ColMod.XS_4, ColMod.MD_2, ColOffsetMod.MD_OFFSET_3);
		col13.addComponent(botonElimConf);
		Col col14 = row6.addCol(ColMod.XS_4, ColOffsetMod.XS_OFFSET_4, ColMod.MD_2, ColOffsetMod.MD_OFFSET_2);
		col14.addComponent(botonElimCancel);
		Col col15 = row6.addCol(ColMod.XS_12, ColMod.MD_6, ColOffsetMod.MD_OFFSET_3);
		col15.addComponent(labelInstructorConf);
		Col col16 = row6.addCol(ColMod.XS_12, ColMod.MD_6, ColOffsetMod.MD_OFFSET_3);
		col16.addComponent(labelInstructor);
		Col col17 = row6.addCol(ColMod.XS_4, ColMod.MD_2, ColOffsetMod.MD_OFFSET_3);
		col17.addComponent(botonInstructorElimConf);
		Col col18 = row6.addCol(ColMod.XS_4, ColOffsetMod.XS_OFFSET_4, ColMod.MD_2, ColOffsetMod.MD_OFFSET_2);
		col18.addComponent(botonInstructorElimCancel);
		Col col19 = row6.addCol(ColMod.XS_12, ColMod.MD_6, ColOffsetMod.MD_OFFSET_3);
		col19.addComponent(labelError);
		Col col20 = row6.addCol(ColMod.XS_12, ColMod.MD_6, ColOffsetMod.MD_OFFSET_3);
		col20.addComponent(labelExito);
		Col col21 = row6.addCol(ColMod.XS_6, ColOffsetMod.XS_OFFSET_3, ColMod.SM_2, ColOffsetMod.SM_OFFSET_5);
		col21.addComponent(botonAceptar);
		
		mainLayout.addComponent(container);
		
		MyUI.getCurrent().setContent(this);
		
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setStyleName("layout-usuarios");
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// labelTitulo
		labelTitulo = new Label();
		labelTitulo.setStyleName("titulo");
		labelTitulo.setImmediate(false);
		labelTitulo.setWidth("-1px");
		labelTitulo.setHeight("-1px");
		labelTitulo.setValue("Usuarios del sistema");
		mainLayout.addComponent(labelTitulo, "top:20.0px;left:49.0px;");
		
		// tablaUsuarios
		tablaUsuarios = new Table();
		tablaUsuarios.setStyleName("tabla");
		tablaUsuarios.setCaption("Usuarios");
		tablaUsuarios.setImmediate(false);
		tablaUsuarios.setWidth("-1px");
		tablaUsuarios.setHeight("400px");
		mainLayout.addComponent(tablaUsuarios, "top:80.0px;left:49.0px;");
		
		// tablaInstructor
		tablaInstructor = new Table();
		tablaInstructor.setStyleName("tabla");
		tablaInstructor.setCaption("Instructores");
		tablaInstructor.setImmediate(false);
		tablaInstructor.setWidth("-1px");
		tablaInstructor.setHeight("400px");
		mainLayout.addComponent(tablaInstructor, "top:80.0px;left:500.0px;");
		
		// botonInstructorElim
		botonInstructorElim = new Button();
		botonInstructorElim.setStyleName("usuarios-boton");
		botonInstructorElim.setCaption("Elegir");
		botonInstructorElim.setImmediate(true);
		botonInstructorElim.setWidth("-1px");
		botonInstructorElim.setHeight("-1px");
		mainLayout.addComponent(botonInstructorElim, "top:568.0px;left:499.0px;");
		
		// botonEliminar
		botonEliminar = new Button();
		botonEliminar.setStyleName("usuarios-boton");
		botonEliminar.setCaption("Eliminar");
		botonEliminar.setImmediate(true);
		botonEliminar.setWidth("-1px");
		botonEliminar.setHeight("-1px");
		mainLayout.addComponent(botonEliminar, "top:494.0px;left:49.0px;");
		
		// botonCancelar
		botonCancelar = new Button();
		botonCancelar.setStyleName("usuarios-boton");
		botonCancelar.setCaption("Cancelar");
		botonCancelar.setImmediate(true);
		botonCancelar.setWidth("-1px");
		botonCancelar.setHeight("-1px");
		mainLayout.addComponent(botonCancelar, "top:494.0px;left:178.0px;");
		
		// labelElimConf1
		labelElimConf1 = new Label();
		labelElimConf1.setStyleName("usuarios-texto");
		labelElimConf1.setImmediate(false);
		labelElimConf1.setWidth("340px");
		labelElimConf1.setHeight("-1px");
		labelElimConf1.setValue("Está seguro que desea eliminar a este usuario?");
		mainLayout.addComponent(labelElimConf1, "top:162.0px;left:180.0px;");
		
		// labelElimConf2
		labelElimConf2 = new Label();
		labelElimConf2.setStyleName("usuarios-texto");
		labelElimConf2.setImmediate(false);
		labelElimConf2.setWidth("-1px");
		labelElimConf2.setHeight("-1px");
		labelElimConf2.setValue("Una vez eliminado, los datos no se pueden recuperar.");
		mainLayout.addComponent(labelElimConf2, "top:198.0px;left:160.0px;");
		
		// botonElimConf
		botonElimConf = new Button();
		botonElimConf.setStyleName("usuarios-boton");
		botonElimConf.setCaption("Sí");
		botonElimConf.setImmediate(true);
		botonElimConf.setWidth("-1px");
		botonElimConf.setHeight("-1px");
		mainLayout.addComponent(botonElimConf, "top:288.0px;left:235.0px;");
		
		// botonElimCancel
		botonElimCancel = new Button();
		botonElimCancel.setStyleName("usuarios-boton");
		botonElimCancel.setCaption("No");
		botonElimCancel.setImmediate(true);
		botonElimCancel.setWidth("-1px");
		botonElimCancel.setHeight("-1px");
		mainLayout.addComponent(botonElimCancel, "top:288.0px;left:330.0px;");
		
		// botonInstructorElimConf
		botonInstructorElimConf = new Button();
		botonInstructorElimConf.setStyleName("usuarios-boton");
		botonInstructorElimConf.setCaption("Sí");
		botonInstructorElimConf.setImmediate(true);
		botonInstructorElimConf.setWidth("-1px");
		botonInstructorElimConf.setHeight("-1px");
		mainLayout.addComponent(botonInstructorElimConf, "top:314.0px;left:235.0px;");
		
		// botonInstructorElimCancel
		botonInstructorElimCancel = new Button();
		botonInstructorElimCancel.setStyleName("usuarios-boton");
		botonInstructorElimCancel.setCaption("No");
		botonInstructorElimCancel.setImmediate(true);
		botonInstructorElimCancel.setWidth("-1px");
		botonInstructorElimCancel.setHeight("-1px");
		mainLayout.addComponent(botonInstructorElimCancel, "top:314.0px;left:330.0px;");
		
		// labelInstructorConf
		labelInstructorConf = new Label();
		labelInstructorConf.setStyleName("usuarios-texto");
		labelInstructorConf.setImmediate(false);
		labelInstructorConf.setWidth("-1px");
		labelInstructorConf.setHeight("-1px");
		labelInstructorConf.setValue("Los expedientes asociados a éste usuario se le asignarán a:");
		mainLayout.addComponent(labelInstructorConf, "top:222.0px;left:140.0px;");
		
		// labelInstructor
		labelInstructor = new Label();
		labelInstructor.setStyleName("usuarios-texto");
		labelInstructor.setImmediate(false);
		labelInstructor.setWidth("-1px");
		labelInstructor.setHeight("-1px");
		labelInstructor.setValue("Instructor nuevo");
		mainLayout.addComponent(labelInstructor, "top:260.0px;left:254.0px;");
		
		// labelUsuarioElim
		labelUsuarioElim = new Label();
		labelUsuarioElim.setStyleName("usuarios-texto");
		labelUsuarioElim.setImmediate(false);
		labelUsuarioElim.setWidth("-1px");
		labelUsuarioElim.setHeight("-1px");
		labelUsuarioElim.setValue("Usuario a eliminar:");
		mainLayout.addComponent(labelUsuarioElim, "top:80.0px;left:254.0px;");
		
		// labelUsuario
		labelUsuario = new Label();
		labelUsuario.setStyleName("usuarios-texto");
		labelUsuario.setImmediate(false);
		labelUsuario.setWidth("-1px");
		labelUsuario.setHeight("-1px");
		labelUsuario.setValue("Usuario elim");
		mainLayout.addComponent(labelUsuario, "top:120.0px;left:240.0px;");
		
		// labelExito
		labelExito = new Label();
		labelExito.setStyleName("exito usuarios-texto centrado");
		labelExito.setImmediate(false);
		labelExito.setWidth("-1px");
		labelExito.setHeight("-1px");
		labelExito.setValue("Usuario eliminado exitosamente!");
		mainLayout.addComponent(labelExito, "top:300.0px;left:220.0px;");
		
		// labelError
		labelError = new Label();
		labelError.setStyleName("error usuarios-texto centrado");
		labelError.setImmediate(false);
		labelError.setWidth("-1px");
		labelError.setHeight("-1px");
		labelError.setValue("Error en el sistema!");
		mainLayout.addComponent(labelError, "top:300.0px;left:260.0px;");
		
		// botonAceptar
		botonAceptar = new Button();
		botonAceptar.setStyleName("usuarios-boton");
		botonAceptar.setCaption("Aceptar");
		botonAceptar.setImmediate(true);
		botonAceptar.setWidth("-1px");
		botonAceptar.setHeight("-1px");
		mainLayout.addComponent(botonAceptar, "top:340.0px;left:269.0px;");
		
		// botonInstructorCancel
		botonInstructorCancel = new Button();
		botonInstructorCancel.setStyleName("usuarios-boton");
		botonInstructorCancel.setCaption("Cancel");
		botonInstructorCancel.setImmediate(true);
		botonInstructorCancel.setWidth("-1px");
		botonInstructorCancel.setHeight("-1px");
		mainLayout.addComponent(botonInstructorCancel, "top:568.0px;left:620.0px;");
		
		// labelInstrucciones
		labelInstrucciones = new Label();
		labelInstrucciones.setStyleName("usuarios-texto");
		labelInstrucciones.setImmediate(false);
		labelInstrucciones.setWidth("321px");
		labelInstrucciones.setHeight("-1px");
		labelInstrucciones.setValue(
				"Elija el instructor al cual se le asignarán los expedientes asociados al usuario por eliminar.");
		mainLayout.addComponent(labelInstrucciones, "top:494.0px;left:499.0px;");
		
		return mainLayout;
	}
}
