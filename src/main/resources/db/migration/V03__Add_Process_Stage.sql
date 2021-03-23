alter table process add column previous_stage bigint constraint previous_stage_fk REFERENCES process_stage(id);
alter table process add column current_stage bigint constraint current_stage_fk REFERENCES process_stage(id);
alter table process add column next_stage bigint constraint next_stage_fk REFERENCES process_stage(id);




