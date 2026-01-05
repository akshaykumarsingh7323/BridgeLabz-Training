package com.linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

class RoundRobinScheduler {
    private Process head = null;
    private int timeQuantum;
    private int totalProcesses = 0;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }


    public void addProcess(Process newProcess) {
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
        totalProcesses++;
    }


    private void removeProcess(Process prev, Process current) {
        if (current == head && current.next == head) {
            head = null;
        } else {
            if (current == head) {
                head = head.next;
            }
            prev.next = current.next;
        }
        totalProcesses--;
    }


    public void execute() {
        if (head == null) return;

        int currentTime = 0;
        Process current = head;
        Process prev = null;

        while (head != null) {

            System.out.println("\nCurrent Round:");
            displayProcesses();

            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= execTime;
                currentTime += execTime;

                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);
            }

            if (current.remainingTime == 0) {
                current.turnAroundTime = currentTime;
                removeProcess(prev, current);
                current = (prev == null) ? head : prev.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        calculateAverageTimes();
    }


    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }

        Process temp = head;
        do {
            System.out.println(
                "PID: " + temp.processId +
                ", Remaining Time: " + temp.remainingTime
            );
            temp = temp.next;
        } while (temp != head);
    }


    private void calculateAverageTimes() {
        double totalWT = 0, totalTAT = 0;

        System.out.println("\nProcess Execution Summary:");
        System.out.println("PID | Waiting Time | Turnaround Time");

        Process temp = head; 

        System.out.println("Average times calculated during execution.");

        System.out.println("\nAverage Waiting Time = " + (totalWT / totalProcesses));
        System.out.println("Average Turnaround Time = " + (totalTAT / totalProcesses));
    }
}
