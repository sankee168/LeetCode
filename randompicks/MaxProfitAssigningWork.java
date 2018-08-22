//Idea here is to go greedy on profit
//Keep profit to difficulty in a data structure and store them in a list
//Sort them based on the profit
//iterate over worker array and keep adding max profit each of them can handle
//O(mlogm) + O(nlogn) where m is the length of difficulty array and n is the length of worker array
 public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < profit.length; i++){
            list.add(new Pair(difficulty[i], profit[i]));
        }
        
        Collections.sort(list, new PairComparator());
        
        Arrays.sort(worker);
        int j = list.size()-1;
        int maxProfit = 0;
        for(int i = worker.length-1; i >= 0; i--){
            int curDiff = worker[i];
            while(j >= 0 && list.get(j).diff > curDiff){
                j--;
            }
            if(j < 0) break;
            maxProfit += list.get(j).profit;
        }
        return maxProfit;
    }
    
    class PairComparator implements Comparator<Pair>{        
        @Override
        public int compare(Pair p1, Pair p2){
            if(p1.profit > p2.profit) return 1;
            else if(p1.profit == p2.profit) return 0;
            return -1;
        }
    }
    
    class Pair {
        int diff;
        int profit;
        
        public Pair(int diff, int profit){
            this.diff = diff;
            this.profit = profit;
        }
    }