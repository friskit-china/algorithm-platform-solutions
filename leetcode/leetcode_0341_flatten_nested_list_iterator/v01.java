package leetcode.leetcode_0341_flatten_nested_list_iterator;

import java.util.*;

public class v01 {
    public static interface NestedInteger{
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }
    public static class CNustedInteger implements NestedInteger{
        private boolean is_integer;
        private Integer data_integer;
        private List<NestedInteger> data_list;
        public CNustedInteger(Integer data){
            this.is_integer = true;
            data_integer = data;
        }

        public CNustedInteger(List<NestedInteger> data){
            this.is_integer = false;
            data_list = data;
        }

        public CNustedInteger(){
            this.is_integer = false;
        }


        @Override
        public boolean isInteger(){
            return this.is_integer;
        }
        @Override
        public Integer getInteger(){
            return this.data_integer;
        }
        @Override
        public List<NestedInteger> getList(){
            return this.data_list;
        }
    }

    static
    class NestedIterator implements Iterator<Integer> {
        private Deque<NestedInteger> deque;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.deque = new ArrayDeque<NestedInteger>();
            for (var item: nestedList){
                var result = expand(item);
                for (var r: result){
                    this.deque.add(r);
                }
            }
        }

        private List<NestedInteger> expand(NestedInteger ni){
            var result = new ArrayList<NestedInteger>();
            if (ni.isInteger()){
                result.add(ni);
                return result;
            }else{
                if (ni.getList() == null || ni.getList().size() == 0){
                    return result;
                }
                for (var item: ni.getList()){
                    var itemResult = expand(item);
                    for (var i: itemResult){
                        result.add(i);
                    }
                }
            }
            return result;
        }
    
        @Override
        public Integer next() {
            return this.deque.pollFirst().getInteger();
        }
    
        @Override
        public boolean hasNext() {
            return this.deque.size() != 0;
        }

    }

    public static void main(String[] argv){
        // var l1 = new ArrayList<NestedInteger>();
        // l1.add(new CNustedInteger(1));
        // l1.add(new CNustedInteger(3));
        // var l2 = new ArrayList<NestedInteger>();
        // l2.add(new CNustedInteger(4));
        // l2.add(new CNustedInteger(5));
        // var l3 = new ArrayList<NestedInteger>();
        // l3.add(new CNustedInteger(l1));
        // l3.add(new CNustedInteger(2));
        // l3.add(new CNustedInteger(l2));
        // var nestedIter = new NestedIterator(l3);
        
        // var l1 = new ArrayList<NestedInteger>();
        // l1.add(new CNustedInteger(0));
        // var nestedIter = new NestedIterator(l1);

        var l1 = new ArrayList<NestedInteger>();
        var l2 = new ArrayList<NestedInteger>();
        l1.add(new CNustedInteger(l2));
        var nestedIter = new NestedIterator(l1);

        while(nestedIter.hasNext()){
            System.out.println(nestedIter.next());
        }

    }
}