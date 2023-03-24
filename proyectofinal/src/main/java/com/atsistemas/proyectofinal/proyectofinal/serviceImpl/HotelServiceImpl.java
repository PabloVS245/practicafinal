package com.atsistemas.proyectofinal.proyectofinal.serviceImpl;



import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.repository.HotelRepository;
import com.atsistemas.proyectofinal.proyectofinal.service.HotelService;



@Service
public class HotelServiceImpl implements HotelService {


	//Creamos una instancia de HotelRepository
	private HotelRepository hotelRepository;
	
	//Inyectamos el Bean HotelRepository por constructor
	public HotelServiceImpl(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}

	
	//Sobreescribimos los métodos de la interfaz HotelService
	
	//Listar Hoteles. Consultar Hoteles
	@Override
	public List<Hotel> listarHoteles() {
		return hotelRepository.findAll();
	}

	//Crear Hotel, Modificar Hotel
	@Override
	@Transactional
	public Hotel guardarHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	
	//Consultar Hotel por Id
	@Override
	public Hotel buscarHotel(Integer id) {
		return hotelRepository.findById(id).get();
	}
	
	//Eliminar Hotel 
	
	@Override
	@Transactional
	public void eliminarHotel(Integer id) {
		hotelRepository.deleteById(id);
	}

}
