package vn.io.tunaa.dsa.exam_2425_2nd_endterm_2.ex3__patient_manager;

public class Patient implements Comparable<Patient> {
    String id; // mã bệnh nhân
    String name; // tên 
    int severity; // mức độ nghiêm trọng

    public Patient(String id, String name, int severity) {
        this.id = id;
        this.name = name;
        this.severity = severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.severity, other.severity);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " (Mức độ: " + severity + ")";
    }
}
