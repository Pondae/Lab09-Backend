package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        Participant pt1, pt2, pt3, pt4, pt5;
        org1 = organizerRepository.save(Organizer.builder()
            .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());

        pt1 = participantRepository.save(Participant.builder()
                .name("A1").telNo("111").build());
        pt2 = participantRepository.save(Participant.builder()
                .name("B2").telNo("222").build());
        pt3 = participantRepository.save(Participant.builder()
                .name("C3").telNo("333").build());
        pt4 = participantRepository.save(Participant.builder()
                .name("D4").telNo("444").build());
        pt5 = participantRepository.save(Participant.builder()
                .name("E5").telNo("555").build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                    .category("Academic")
                    .title("Midterm Exam")
                    .description("A time for taking the exam")
                    .location("CAMT Building")
                    .date("3rd Sept")
                    .time("3.00-4.00 pm.")
                    .petAllowed(false)
                    .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        pt1.getEventHistory().add(tempEvent);
        pt2.getEventHistory().add(tempEvent);
        pt3.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                    .category("Academic")
                    .title("Commencement Day")
                    .description("A time for celebration")
                    .location("CMU Convention hall")
                    .date("21th Jan")
                    .time("8.00am-4.00 pm.")
                    .petAllowed(false)
                    .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                    .category("Cultural")
                    .title("Loy Krathong")
                    .description("A time for Krathong")
                    .location("Ping River")
                    .date("21th Nov")
                    .time("8.00-10.00 pm.")
                    .petAllowed(false)
                    .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        pt4.getEventHistory().add(tempEvent);
        pt5.getEventHistory().add(tempEvent);
        pt1.getEventHistory().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        pt2.getEventHistory().add(tempEvent);
        pt3.getEventHistory().add(tempEvent);
        pt4.getEventHistory().add(tempEvent);
    }
}
