package es.seresco.delincuencia.utils;

//import es.seresco.delincuencia.services.BandasService;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Utilidad {
	
	
	//Ejemplo de como acceder a un bean de Spring desde una clase que no es un Bean.
	public boolean miSuperMetodo() {
	
		
	//	BandasService service = (BandasService) AppContextUtil.getAppContext().getBean("normal");
		
		
		//aqui hago algo con el service.
		
		
		return true;
	}

	
}
