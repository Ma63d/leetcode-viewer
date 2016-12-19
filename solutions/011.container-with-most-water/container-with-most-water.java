public class Solution {
    //ac了 可是速度好慢啊
    //具体就是求出以第i条边为container的一条边时 容量的最大值
    //对于另外一条边j 如果高于第i条边 那么面积等于他们x轴的距离乘以height[i]
    //如果低于第i条边 那么面积等于他们x轴的距离乘以height[j]
    //很显然 对于另一条低于第i条边的情况我们要计算出height[j]*x轴距离
    //而对于高于的情况 只用考虑让x轴距离最大就可以了 因为反正最后都是乘以height[i]
    //所以思想上来说只用去找比当前i边高的j边 让j与i在x轴距离最大即可,
    //因为两条边作为容器的边,我们只用考虑那条较矮的边为i边较高的边为j边即可不然就重复计算了.
    public class Node{
        int height;
        int position;
        Node(int h, int p){
            height = h;
            position = p;
        }
    }
    public void quickSort(Node[] nodeList,int start,int end){
        //对节点列表快排
        int midNum = ((end - start + 1)/2) +start;
        Node temp = nodeList[midNum];
        nodeList[midNum] = nodeList[start];
        nodeList[start] = temp;
        Node pivotNode = nodeList[start];
        int front = start,tail = end;
        while(front != tail){
            while(nodeList[tail].height >= pivotNode.height && front != tail){
                tail--;
            }
            nodeList[front] = nodeList[tail];
            while(nodeList[front].height <= pivotNode.height && front != tail){
                front++;
            }
            nodeList[tail] = nodeList[front];
        }
        nodeList[front] = pivotNode;
        if(front -1 > start){
            quickSort(nodeList,start,front-1);
        }
        if(front + 1 < end){
            quickSort(nodeList,front+1,end);
        }
    }
    public int maxArea(int[] height) {
        if(height.length < 1){
            return 0;
        }
        if(height.length == 2){
            return height[0] > height[1]?height[1]:height[0];
        }
        Node[] nodeList = new Node[height.length];
        for(int i = 0; i < height.length;i++){
            nodeList[i] = new Node(height[i],i);
        }
        quickSort(nodeList,0,height.length-1);
        int[] rank = new int[height.length];
        // rank[i]记录从小到大排序height[i]排在第几;
        for(int i = 0; i < height.length;i++){
            rank[nodeList[i].position] = i;
        }
        //用rmq排序
        int logNum = (int)(Math.log(rank.length)/Math.log(2));
        int[][] rmq_max = new int[rank.length][logNum+1];
        int[][] rmq_min = new int[rank.length][logNum+1];
        for(int i = 0;i<rank.length;i++){
            rmq_max[i][0] = nodeList[i].position;
            rmq_min[i][0] = nodeList[i].position;
        }
        for(int j = 1;j <= logNum;j++){
            for(int i = 0; i + (1 << j) -1 < rank.length; i++){
                rmq_max[i][j] = rmq_max[i][j-1] > rmq_max[i + (1 << j-1)][j-1]?rmq_max[i][j-1]:rmq_max[i + (1 << j-1)][j-1];
                rmq_min[i][j] = rmq_min[i][j-1] > rmq_min[i + (1 << j-1)][j-1]?rmq_min[i + (1 << j-1)][j-1]: rmq_min[i][j-1];
            }
        }
        int maxArea = 0;
        if(rank[0] != height.length -1 ){
            int rankNum = rank[0];
            int nodeRest = height.length - rankNum -1;
            int restLog = (int)(Math.log(nodeRest)/Math.log(2));
            int furthestPoint = Math.max(rmq_max[rankNum+1][restLog],rmq_max[height.length - (1 << restLog)][restLog]);
            maxArea = furthestPoint * height[0];
        }
        for(int i = 0; i < height.length;i++){
            int area = 0;
            int rankNum = rank[i];
            if(rank[i] != height.length -1 ){
                int nodeRest = height.length - rankNum -1;
                int restLog = (int)(Math.log(nodeRest)/Math.log(2));
                int furthestRightPoint = Math.max(rmq_max[rankNum+1][restLog],rmq_max[height.length - (1 << restLog)][restLog]);
                int furthestLeftPoint = Math.min(rmq_min[rankNum+1][restLog],rmq_min[height.length - (1 << restLog)][restLog]);
                area = Math.max(Math.abs(furthestRightPoint - i),Math.abs(furthestLeftPoint - i))* height[i];
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}