package co.com.smartfit.franquicias.acondicionamientofisico.agregadosede;

import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.events.*;
import co.com.smartfit.franquicias.acondicionamientofisico.agregadosede.values.*;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Fecha;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Nombre;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Serial;
import co.com.smartfit.franquicias.acondicionamientofisico.genericos.Telefono;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Sede extends AggregateEvent<SedeId> {

    protected MaquinaId maquinaId;
    protected SedeId sedeId;
    protected Nombre nombreSede;
    protected Ciudad ciudad;
    protected Direccion direccion;
    protected Telefono telefono;
    protected Maquina maquina;
    protected Torniquete torniquete;

    protected EstadoMantenimiento estadoMantenimiento;

    public Sede(SedeId sedeId, Nombre nombreSede,
                Ciudad ciudad, Direccion direccion,
                Telefono telefono) {
        super(sedeId);
        appendChange(new SedeCreada(nombreSede, ciudad, direccion, telefono)).apply();
        subscribe(new SedeEventChange(this));
    }

    private Sede(SedeId sedeId) {
        super(sedeId);
        subscribe(new SedeEventChange(this));
    }

    public static Sede from(SedeId sedeId, List<DomainEvent> events) {
        var sede = new Sede(sedeId);
        events.forEach(sede::applyEvent);
        return sede;
    }

    public void crearTorniquete(LectorHuella lectorHuella, Serial serial) {
        var torniqueteId = new TorniqueteId();
        appendChange(new TorniqueteCreado(torniqueteId, lectorHuella, serial)).apply();
    }

    public void crearMaquina(Nombre nombreMaquina,
                             Categoria categoria, Marca marca, Serial serial) {
        var maquinaId = new MaquinaId();
        appendChange(new MaquinaCreada(maquinaId, nombreMaquina, categoria, marca, serial)).apply();
    }

    public void asignarMaquinaAMantenimiento(MaquinaId maquinaId, Nombre nombreMaquina,
                                             Categoria categoria, Marca marca,
                                             Serial serial,
                                             Fecha fecha) {
        appendChange(new MaquinaAMantenimientoAsignada(maquinaId, nombreMaquina, categoria,
                marca, serial, fecha)).apply();
    }

    public void cambiarTelefonoSede(SedeId sedeId, Telefono telefono) {
        appendChange(new TelefonoSedeCambiado(sedeId, telefono)).apply();
    }

    public void reemplazarMaquina(Nombre nombreMaquina,
                                  Categoria categoria, Marca marca, Serial serial) {
        var maquinaId = new MaquinaId();
        appendChange(new MaquinaReemplazada(maquinaId, nombreMaquina, categoria, marca, serial)).apply();
    }

    public void reemplazarTorniquete(LectorHuella lectorHuella, Serial serial) {
        var torniqueteId = new TorniqueteId();
        appendChange(new TorniqueteReemplazado(torniqueteId, lectorHuella, serial)).apply();
    }

    public void eliminarMaquina(MaquinaId maquinaId){
        appendChange(new MaquinaEliminada(maquinaId)).apply();
    }
}
