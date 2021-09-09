package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.Optional;

@Repository
public class ParticipantDaoImpl implements ParticipantDao{
    @Autowired
    ParticipantRepository participantRepository;
    @Override
    public Page<Participant> getParticipant(Pageable pageRequest) {
        return participantRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Participant> findById(Long id) {
        return participantRepository.findById(id);
    }
}
