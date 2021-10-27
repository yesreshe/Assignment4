import java.io.IOException;
import java.util.*;

public class CourseDBStructure implements CourseDBStructureInterface {
        protected int size;
        protected LinkedList<CourseDBElement> hashTable[];
        
        @SuppressWarnings("unchecked")
        public CourseDBStructure(int size) {
                this.size = size;
                hashTable = new LinkedList[size];
        }
        
        @SuppressWarnings("unchecked")
        public CourseDBStructure(String testing, int size) {
                this.size = size;
                hashTable = new LinkedList[size];
        }
        
        @Override
        public void add(CourseDBElement element) {
                int index = element.hashCode() % size;
                if(hashTable[index] == null) {
                        hashTable[index] = new LinkedList<CourseDBElement>();
                }
                hashTable[index].add(element);
        }
        
        @Override
        public CourseDBElement get(int crn) throws IOException {
                String str = crn + "";
                int index = str.hashCode() % size;
                if(hashTable[index] == null) {
                        throw new IOException();
                }
                else {
                        for(int i = 0; i < size; i++) {
                                CourseDBElement temp = hashTable[index].get(i);
                                if(temp.getCRN() == crn) {
                                        return temp;
                                }
                        }
                        return null;
                }
        }
        
        @Override
        public int getTableSize() {
                return size;
        }

}