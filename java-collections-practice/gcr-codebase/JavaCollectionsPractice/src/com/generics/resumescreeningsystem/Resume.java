package com.generics.resumescreeningsystem;

class Resume<T extends JobRole> {

    T job;

    Resume(T job) {
        this.job = job;
    }

    void process() {
        System.out.println(job.name + " | " +
                           job.role() + " | Score: " +
                           job.score());
    }
}

