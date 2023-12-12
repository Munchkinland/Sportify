import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestionReservas {
    private static List<Reserva> reservasActivas = new ArrayList<>();

    public static void agregarReserva(Reserva reserva) {
        reservasActivas.add(reserva);
    }

    public static List<Reserva> obtenerReservasActivas() {
        return reservasActivas;
    }

    public static void anularReserva(String descripcionReserva) {
        // Utilizar un iterador para evitar ConcurrentModificationException
        Iterator<Reserva> iterator = reservasActivas.iterator();
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.toString().equals(descripcionReserva)) {
                iterator.remove();
                break;
            }
        }
    }
}


