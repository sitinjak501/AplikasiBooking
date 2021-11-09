package Proses;

public class History {
    String nama, nomorponsel, tanggalbermain, jambermain, lamabermain, email, status, harga, lapangan;

public History(){

}
    public History(String nama, String nomorponsel, String tanggalbermain, String jambermain, String lamabermain, String email, String status, String harga, String lapangan) {
        this.nama = nama;
        this.nomorponsel = nomorponsel;
        this.tanggalbermain = tanggalbermain;
        this.jambermain = jambermain;
        this.email = email;
        this.lamabermain = lamabermain;
        this.status=status;
        this.harga=harga;
        this.lapangan = lapangan;
}
    public String getNama() { return nama;
    }

    public void setNama(String nama) { this.nama =nama;
    }

    public String getNomorponsel() {
        return nomorponsel;
    }

    public void setNomorponsel(String nomorponsel) { this.nomorponsel =nomorponsel;
    }

    public String getTanggalbermain() {
        return tanggalbermain;
    }

    public void setTanggalbermain(String tanggalbermain) { this.tanggalbermain =tanggalbermain;
    }

    public String getJambermain() {
        return jambermain;
    }

    public void setJambermain(String jambermain) { this.jambermain =jambermain;
    }

    public String getLamabermain() {
        return lamabermain;
    }

    public void setLamabermain(String lamabermain) { this.lamabermain =lamabermain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email =email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { this.status =status;
    }

    public String getHarga() { return harga;
    }

    public void setHarga(String harga) { this.harga =harga;
    }

    public String getLapangan() { return lapangan;
    }

    public void setLapangan(String lapangan) { this.lapangan = lapangan;
    }
}