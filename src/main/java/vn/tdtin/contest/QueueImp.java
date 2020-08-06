package vn.tdtin.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QueueImp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String [] inputParams = input.split(" ");
        int n = Integer.parseInt(inputParams[0]);
        int capacity = Integer.parseInt(inputParams[1]);

        String [] output = new String[n];
        Queue queue = new Queue(capacity);

        //O(n)
        for(int i =0 ; i < n ; i++) {
            input = br.readLine();
            inputParams = input.split(" ");
            ACTION action = ACTION.valueOf(inputParams[0].toUpperCase());
            String inputText = inputParams.length > 1 ? inputParams[1] : "";
            output[i] = action.doAction(queue,inputText);
        }

        //O(n)
        for(int i =0 ; i < n ; i++) {
            System.out.println(output[i]);
        }
    }

    private static class Queue {
        int front, rear, size;
        int capacity;
        String array[];

        public Queue(int capacity) {
            this.capacity = capacity;
            front = this.size = 0;
            rear = capacity - 1;
            array = new String[this.capacity];
        }

        //O(1)
        boolean isFull(Queue queue) {
            return (queue.size == queue.capacity);
        }

        //O(1)
        boolean isEmpty(Queue queue)
        {
            return (queue.size == 0);
        }

        //O(1)
        boolean offer(String item)
        {
            if (isFull(this))
                return false;
            this.rear = (this.rear + 1)
                    % this.capacity;
            this.array[this.rear] = item;
            this.size = this.size + 1;
            return true;
        }

        //O(1)
        String take() {
            if (isEmpty(this))
                return "";

            String item = this.array[this.front];
            this.front = (this.front + 1) % this.capacity;
            this.size = this.size - 1;
            return item;
        }

        int size () {
            return size;
        }

    }

    private static enum ACTION {
        OFFER {
            @Override
            String doAction(Queue queue, String input) {
                return Boolean.toString(queue.offer(input));
            }
        },
        TAKE {
            @Override
            String doAction(Queue queue, String input) {
                return queue.take();
            }
        },
        SIZE {
            @Override
            String doAction(Queue queue, String input) {
                return Integer.toString(queue.size());
            }
        };
        abstract String doAction(Queue queue, String input) ;
    }
}
