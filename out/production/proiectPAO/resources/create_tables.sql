DROP TABLE IF EXISTS AnalizaMedicala, Consultatie, Factura, IstoricMedical, Medic, Pacient, Programare, Reteta CASCADE;

CREATE TABLE Pacient (
                         id VARCHAR(20) PRIMARY KEY,
                         nume VARCHAR(100) NOT NULL,
                         prenume VARCHAR(100) NOT NULL,
                         cnp VARCHAR(20) NOT NULL UNIQUE,
                         adresa VARCHAR(255),
                         numarTelefon VARCHAR(15) NOT NULL
);

CREATE TABLE Medic (
                       id VARCHAR(20) PRIMARY KEY,
                       nume VARCHAR(100) NOT NULL,
                       specializare VARCHAR(100) NOT NULL
);

CREATE TABLE Factura (
                         id VARCHAR(20) PRIMARY KEY,
                         pacient_id VARCHAR(20),
                         sumaDePlata DECIMAL(15, 2) NOT NULL,
                         dataEmiterii DATE NOT NULL,
                         estePlatita BOOLEAN NOT NULL,
                         FOREIGN KEY (pacient_id) REFERENCES Pacient(id)
);

CREATE TABLE IstoricMedical (
                                idPacient VARCHAR(20) PRIMARY KEY,
                                istoricBoala TEXT NOT NULL,
                                FOREIGN KEY (idPacient) REFERENCES Pacient(id)
);

CREATE TABLE AnalizaMedicala (
                                 id VARCHAR(20) PRIMARY KEY,
                                 nume VARCHAR(100) NOT NULL,
                                 rezultat TEXT NOT NULL,
                                 data DATE NOT NULL,
                                 pacient_id VARCHAR(20),
                                 FOREIGN KEY (pacient_id) REFERENCES Pacient(id)
);

CREATE TABLE Consultatie (
                             id VARCHAR(20) PRIMARY KEY,
                             data DATE NOT NULL,
                             diagnostic TEXT NOT NULL,
                             pacient_id VARCHAR(20),
                             medic_id VARCHAR(20),
                             FOREIGN KEY (pacient_id) REFERENCES Pacient(id),
                             FOREIGN KEY (medic_id) REFERENCES Medic(id)
);

CREATE TABLE Programare (
                            id VARCHAR(20) PRIMARY KEY,
                            data DATE NOT NULL,
                            ora TIME NOT NULL,
                            pacient_id VARCHAR(20),
                            medic_id VARCHAR(20),
                            FOREIGN KEY (pacient_id) REFERENCES Pacient(id),
                            FOREIGN KEY (medic_id) REFERENCES Medic(id)
);

CREATE TABLE Reteta (
                        id VARCHAR(20) PRIMARY KEY,
                        medic_id VARCHAR(20),
                        pacient_id VARCHAR(20),
                        medicamente TEXT NOT NULL,
                        FOREIGN KEY (medic_id) REFERENCES Medic(id),
                        FOREIGN KEY (pacient_id) REFERENCES Pacient(id)
);

-- Select all data from tables
SELECT * FROM Pacient;
SELECT * FROM Medic;
SELECT * FROM Factura;
SELECT * FROM IstoricMedical;
SELECT * FROM AnalizaMedicala;
SELECT * FROM Consultatie;
SELECT * FROM Programare;
SELECT * FROM Reteta;
