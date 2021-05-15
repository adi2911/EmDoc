package com.example.emdoc;

public class Fields {
    String email, spec;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpec() {
        final String spec = this.spec;
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
