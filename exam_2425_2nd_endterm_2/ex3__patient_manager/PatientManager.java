package vn.io.tunaa.dsa.exam_2425_2nd_endterm_2.ex3__patient_manager;

import java.io.File;
import java.util.*;

class PatientManager {
    // Đọc dữ liệu từ tệp input.txt
    public static List<Patient> readFromFile(String filename) {
        List<Patient> patients = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(filename));

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(";");

                patients.add(new Patient(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
            }
        } catch (Exception ignored) {}

        return patients;
    }

    // Trả về hàng đợi ưu tiên từ danh sách bệnh nhân (bệnh nhân có mức độ nghiêm trọng thấp sẽ có độ ưu tiên cao)
    public PriorityQueue<Patient> getPriorityPatients(List<Patient> patients) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.severity));

        for (Patient patient : patients) {
            pq.offer(patient);
        }

        return pq;
    }

    // Trả về danh sách bệnh nhân có mức độ nghiêm trọng là 1
    public List<Patient> getHighestPriorityPatients(PriorityQueue<Patient> queue) {
        List<Patient> patients = new ArrayList<>();

        while (!queue.isEmpty() && queue.peek().severity == 1) {	 	  	 		      	     		   	       	 	
            patients.add(queue.poll());
        }

        return patients;
    }
}