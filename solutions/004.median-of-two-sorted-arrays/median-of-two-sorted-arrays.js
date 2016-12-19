/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
        var length = nums1.length + nums2.length;
        if(length % 2 ){
            return getIndexK(nums1,0,nums2,0,(1+length)/2)
        }else{
            return (getIndexK(nums1,0,nums2,0,(length)/2)+getIndexK(nums1,0,nums2,0,(length)/2+1))/2
        }
    };



function getIndexK(a,startA,b,startB,k){
        //具体就是拿前一个数组的第k/2个元素跟后一个数组的第k/2个元素比大小
        //如果前一个小,那说明前一个数组的第k/2个元素最最最多也就是总排行第k-1大的那个,不能更多,所以抛弃掉前一个数组的前k/2个元素
        //如果后一个小,同理
        //如果相等 说明这两个元素都是排行第k大的元素 直接返回
        if(a.length - startA > b.length - startB){
            return getIndexK(b,startB,a,startA,k);
        }
        if(startA >= a.length){
            return b[startB+k-1];
        }
        if(k==1)
            return Math.min(a[startA],b[startB]);
        var pa = Math.min(a.length - startA, Math.floor(k/2)),pb = k - pa;
        if(a[startA+pa-1] > b[startB+pb-1]){
            return getIndexK(a,startA,b,startB+pb,k-pb)
        }else if(a[startA+pa-1] < b[startB+pb-1]){
            return getIndexK(a,startA+pa,b,startB,k-pa)
        }else{
            return a[startA+pa-1];
        }
    }