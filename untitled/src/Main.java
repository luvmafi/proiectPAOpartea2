import model.*;
import service.*;
import dao.impl.*;
import daoservices.*;
import daoservices.impl.*;

import java.time.LocalDate;
import java.util.*;

import model.*;
import service.*;
import daoservices.impl.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        PacientRepoService pacientRepoService = new PacientRepoServiceImpl();
        PacientService pacientService = new PacientService(pacientRepoService);

        MedicRepoService medicRepoService = new MedicRepoServiceImpl();
        MedicService medicService = new MedicService(medicRepoService);

        FacturaRepoService facturaService = new FacturaRepoServiceImpl();


        Pacient pacient1 = new Pacient("1", "Popescu", "Ion", "0000000000000", "Str. Libertatii nr. 10", "0722222222");
        Pacient pacient2 = new Pacient("2", "Ionescu", "Maria", "0000000000001", "Str. Unirii nr. 4", "0733333333");

        pacientService.adaugaPacient(pacient1);
        pacientService.adaugaPacient(pacient2);


        Medic medic1 = new Medic("1", "Dr. Ana Ionescu", "Cardiologie");
        Medic medic2 = new Medic("2", "Dr. Mircea Popa", "Dermatologie");

        medicService.adaugaMedic(medic1);
        medicService.adaugaMedic(medic2);


        Factura factura1 = new Factura("1", pacient1.getId(), 100.50, LocalDate.now(), false);
        Factura factura2 = new Factura("2", pacient2.getId(), 200.75, LocalDate.now(), true);
        facturaService.adaugaFactura(factura1);


        System.out.println("Toate facturile:");
        facturaService.afiseazaToateFacturile();


        Factura facturaGasita = facturaService.obtineFacturaDupaId("1");
        if (facturaGasita != null) {
            System.out.println("Factura găsită: " + facturaGasita);
        } else {
            System.out.println("Factura cu ID-ul 1 nu a fost găsită.");
        }


        facturaService.stergeFacturaDupaId("1");
        System.out.println("Factura cu ID-ul 1 a fost ștearsă.");


        System.out.println("Toate facturile după ștergere:");
        facturaService.afiseazaToateFacturile();
    }
}
