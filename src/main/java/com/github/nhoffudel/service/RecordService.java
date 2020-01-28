package com.github.nhoffudel.service;

import com.github.nhoffudel.model.Record;
import com.github.nhoffudel.repository.RecordHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    private RecordHandler handler;

    @Autowired
    public RecordService(RecordHandler handler) {
        this.handler = handler;
    }

    public Record create(Record record) {
        Record recordCreated = handler.create(record);
        return recordCreated;
    }

    public Record read(Long id) {
        Record potentialRecord = handler.findById(id);
        return potentialRecord;
    }

    public Record update(Long id, Record record) {
        Record recordInDataBase = read(id);
        String newNotes = record.getNotes();
        recordInDataBase.setNotes(newNotes);
        handler.update(recordInDataBase);
        return recordInDataBase;
    }

    public Record delete(Long id) {
        Record record = read(id);
        handler.delete(record);
        return record;
    }

    public List<Record> readAll() {
        return handler.findAll();
    }
}
