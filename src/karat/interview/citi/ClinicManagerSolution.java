package karat.interview.citi.two;

/*
We are building the back-end for a clinic appointment management system.
The system tracks doctors and appointments.

Definitions:
* A "doctor" has: doctorId, name.
* An "appointment" has: appointmentId, doctorId, patientId,
  durationMinutes, status, appointmentType.
* AppointmentStatus is one of: SCHEDULED, COMPLETED, CANCELLED, NO_SHOW.
* AppointmentType is one of: CONSULTATION, FOLLOWUP, EMERGENCY.
* "ClinicManager" manages doctors, appointments, and provides statistics.


We are extending the platform to report on appointment durations by type.

Recall that each Appointment carries an appointmentType, one of
CONSULTATION, FOLLOWUP, EMERGENCY.

Add a new function to the ClinicManager class:

2) The getAverageAppointmentDurationByType function should return a
   dictionary mapping each appointment type (CONSULTATION, FOLLOWUP,
   EMERGENCY) to the doctor's average appointment duration in minutes for
   that type. Only appointments with a COMPLETED status should be counted;
   ignore appointments with any other status. Only appointment types the
   doctor has at least one completed appointment for should appear in the
   dictionary. If the doctor has no completed appointments at all, return
   an empty dictionary.

To assist you in testing this new function, we have provided the
testGetAverageAppointmentDurationByType test.
*/
import java.util.*;

enum AppointmentStatus {
	SCHEDULED, COMPLETED, CANCELLED, NO_SHOW
}

enum AppointmentType {
	CONSULTATION, FOLLOWUP, EMERGENCY
}

public class Solution {


}

class Doctor {

	public int doctorId;
	public String name;

	public Doctor( int doctorId, String name ) {

		this.doctorId = doctorId;
		this.name = name;
	}
}

class Appointment {

	public int appointmentId;
	public int doctorId;
	public int patientId;
	public int durationMinutes;
	public AppointmentStatus status;
	public AppointmentType appointmentType;

	public Appointment( int appointmentId, int doctorId, int patientId,
	                    int durationMinutes, AppointmentStatus status,
	                    AppointmentType appointmentType ) {

		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.durationMinutes = durationMinutes;
		this.status = status;
		this.appointmentType = appointmentType;
	}
}

class AppointmentStats {

	public int totalAppointments;
	public int completedAppointments;
	public double noShowRate;

	public AppointmentStats( int totalAppointments, int completedAppointments, double noShowRate ) {

		this.totalAppointments = totalAppointments;
		this.completedAppointments = completedAppointments;
		this.noShowRate = noShowRate;
	}
}

class ClinicManager {

	public Map<Integer, Doctor> doctors;
	public List<Appointment> appointments;

	public ClinicManager() {

		doctors = new HashMap<>();
		appointments = new ArrayList<>();
	}

	static void testGetAppointmentStatistics() {

		System.out.println("\t--- Running testGetAppointmentStatistics ---");
		ClinicManager cm = new ClinicManager();
		cm.addDoctor(new Doctor(10, "dr_smith"));
		cm.addAppointment(new Appointment(1, 10, 100, 30, AppointmentStatus.COMPLETED, AppointmentType.CONSULTATION));
		cm.addAppointment(new Appointment(2, 10, 101, 45, AppointmentStatus.COMPLETED, AppointmentType.FOLLOWUP));
		cm.addAppointment(new Appointment(3, 10, 102, 30, AppointmentStatus.NO_SHOW, AppointmentType.EMERGENCY));
		cm.addAppointment(new Appointment(4, 10, 103, 60, AppointmentStatus.CANCELLED, AppointmentType.CONSULTATION));
		cm.addAppointment(new Appointment(5, 10, 104, 30, AppointmentStatus.SCHEDULED, AppointmentType.FOLLOWUP));
		AppointmentStats stats = cm.getAppointmentStatistics();
		assert stats.totalAppointments == 5 :
				"totalAppointments should be 5, was " + stats.totalAppointments;
		assert stats.completedAppointments == 2 :
				"completedAppointments should be 2, was " + stats.completedAppointments;
		assert Math.abs(stats.noShowRate - 0.2) < 1e-4 :
				"noShowRate should be 0.2, was " + stats.noShowRate;
	}

	static void testGetAverageAppointmentDurationByType() {

		System.out.println("\t--- Running testGetAverageAppointmentDurationByType ---");
		ClinicManager cm = new ClinicManager();
		cm.addDoctor(new Doctor(1, "dr_smith"));
		cm.addDoctor(new Doctor(2, "dr_jones"));
		cm.addAppointment(new Appointment(1, 1, 100, 30, AppointmentStatus.COMPLETED, AppointmentType.CONSULTATION));
		cm.addAppointment(new Appointment(2, 1, 101, 41, AppointmentStatus.COMPLETED, AppointmentType.CONSULTATION));
		cm.addAppointment(new Appointment(3, 1, 102, 20, AppointmentStatus.COMPLETED, AppointmentType.FOLLOWUP));
		// not COMPLETED -> excluded from averages
		cm.addAppointment(new Appointment(5, 1, 105, 100, AppointmentStatus.CANCELLED, AppointmentType.CONSULTATION));
		cm.addAppointment(new Appointment(4, 2, 103, 40, AppointmentStatus.COMPLETED, AppointmentType.EMERGENCY));

		int id = 1;
		Map<AppointmentType, Double> avg1 = cm.getAverageAppointmentDurationByType(id);

		Map<Integer, Doctor> doctorMap = cm.doctors;
		String docName = "";
		if ( doctorMap.containsKey(id) ) {
			docName = doctorMap.get(id).name.toUpperCase();
		}

		assert Math.abs(35.5 - avg1.get(AppointmentType.CONSULTATION)) < 1e-4 : "Expected 35.5 for CONSULTATION";  // (30+41)/2
		assert Math.abs(20.0 - avg1.get(AppointmentType.FOLLOWUP)) < 1e-4 : "Expected 20.0 for FOLLOWUP";
		assert !avg1.containsKey(AppointmentType.EMERGENCY) : "EMERGENCY should not be in avg1";

		System.out.println();

		// ITERATING OVER ENTRY SET WITH FOR-EACH
		for ( Map.Entry<AppointmentType, Double> entry : avg1.entrySet() ) {
			System.out.printf("%s average time for %s: %.2f mins\n", docName, entry.getKey(), entry.getValue());
		}

		System.out.println();

		id = 2;
		if ( doctorMap.containsKey(id) ) {
			docName = doctorMap.get(id).name.toUpperCase();
		}

		Map<AppointmentType, Double> avg2 = cm.getAverageAppointmentDurationByType(id);
		assert Math.abs(40.0 - avg2.get(AppointmentType.EMERGENCY)) < 1e-4 : "Expected 40.0 for EMERGENCY";
		assert !avg2.containsKey(AppointmentType.CONSULTATION) : "CONSULTATION should not be in avg2";
		assert !avg2.containsKey(AppointmentType.FOLLOWUP) : "FOLLOWUP should not be in avg2";

		// ITERATING OVER MAP WITH LAMBDA
//		avg2.forEach(( key, value ) -> {
//			System.out.printf("Average time for appointment type %s : %.2f\n", key, value);
//		});

		/* ITERATING OVER MAP WITH ITERATOR */
		Iterator<Map.Entry<AppointmentType, Double>> iter = avg2.entrySet().iterator();

		while ( iter.hasNext() ) {
			Map.Entry<AppointmentType, Double> entry = iter.next();

			System.out.printf("%s average time for %s: %.2f mins\n", docName, entry.getKey(),
					entry.getValue());
		}
		System.out.println();

		// doctor with no appointments
		cm.addDoctor(new Doctor(3, "dr_brown"));
		assert cm.getAverageAppointmentDurationByType(3).isEmpty() : "Expected empty map for doctor with no appointments";
		// unknown doctorId -> empty map
		assert cm.getAverageAppointmentDurationByType(999).isEmpty() : "Expected empty map for unknown doctorId";


	}

	static void main( String[] args ) {


		testGetAppointmentStatistics();
		System.out.println("\t\t All tests passed ");
		testGetAverageAppointmentDurationByType();
		System.out.println("\t\t All tests passed ");
	}

	// complete this method
	public Map<AppointmentType, Double> getAverageAppointmentDurationByType( int doctorId ) {

		if ( !doctors.containsKey(doctorId) ) {
			return new HashMap<>();
		}

		Map<AppointmentType, Integer> countByType = new HashMap<>();
		Map<AppointmentType, Integer> totalDurationByType = new HashMap<>();

		for ( Appointment appt : appointments ) {
			if ( appt.doctorId == doctorId && appt.status == AppointmentStatus.COMPLETED ) {
				AppointmentType type = appt.appointmentType;

				countByType.put(type, countByType.getOrDefault(type, 0) + 1);
				totalDurationByType.put(type, totalDurationByType.getOrDefault(type, 0) + appt.durationMinutes);
			}
		}
		if ( countByType.isEmpty() ) {
			return new HashMap<>();
		}

		Map<AppointmentType, Double> avgByType = new HashMap<>();
		for ( AppointmentType type : countByType.keySet() ) {
			double avg = (double) totalDurationByType.get(type) / countByType.get(type);
			avgByType.put(type, avg);
		}

		return avgByType;
	}

	public void addDoctor( Doctor doctor ) {

		doctors.put(doctor.doctorId, doctor);
	}

	public void addAppointment( Appointment appointment ) {

		if ( !doctors.containsKey(appointment.doctorId) ) {
			return;
		}
		appointments.add(appointment);
	}

	public AppointmentStats getAppointmentStatistics() {

		int total = appointments.size();
		int completed = 0;
		for ( Appointment a : appointments ) {
			if ( a.status == AppointmentStatus.COMPLETED ) {
				//|| a.status == AppointmentStatus.NO_SHOW) {
				completed++;
			}
		}
		int noShows = 0;
		for ( Appointment a : appointments ) {
			if ( a.status == AppointmentStatus.NO_SHOW ) {
				noShows++;
			}
		}
		double noShowRate;
		if ( total > 0 ) {
			noShowRate = (double) noShows / total;
		} else {
			noShowRate = 0.0;
		}
		return new AppointmentStats(total, completed, noShowRate);
	}

}