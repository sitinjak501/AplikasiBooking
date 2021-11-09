package com.example.appbook.badmintonbooking;

public class OrderBadminton {

    private String nama;
    private String nomorponsel;
    private String tanggalbermain;
    private String jambermain;
    private String email;
    private String lamabermain;
    private String lapangan;

    public OrderBadminton(){

    }

    public OrderBadminton(String nama, String nomorponsel, String tanggalbermain, String jambermain, String lamabermain, String email, String lapangan) {
        this.nama = nama;
        this.nomorponsel = nomorponsel;
        this.tanggalbermain = tanggalbermain;
        this.jambermain = jambermain;
        this.email = email;
        this.lamabermain = lamabermain;
        this.lapangan = lapangan;
    }

    public String getEmail() { return email;
    }

    public void setEmail(String email) { this.email = email;
    }

    public String getLamabermain() { return lamabermain;
    }

    public void setLamabermain(String lamabermain) { this.lamabermain = lamabermain;
    }

    public String getNama() {  return nama;
    }

    public void setNama(String nama) { this.nama = nama;
    }

    public String getNomorponsel() { return nomorponsel;
    }

    public void setNomorponsel(String nomorponsel) { this.nomorponsel = nomorponsel;
    }

    public String getTanggalbermain() { return tanggalbermain;
    }

    public void setTanggalbermain(String tanggalbermain) { this.tanggalbermain = tanggalbermain;
    }

    public String getJambermain() { return jambermain;
    }

    public void setJambermain(String jambermain) { this.jambermain = jambermain;
    }

    public String getLapangan() { return lapangan;
    }

    public void setLapangan(String lapangan) { this.lapangan = lapangan;
    }
}
