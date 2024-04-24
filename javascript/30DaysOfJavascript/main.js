/**
 * 2667. Create Hello World Function
 * @return {Function}
 */
var createHelloWorld = function () {

    return function (...args) {
        return "Hello World";
    }
};

/**
 * 2620. Counter
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function (n) {
    let count = n;
    return function () {
        return count++;
    };
};

/**
 * 2704. To Be Or Not To Be
 * @param {string} val
 * @return {Object}
 */
var expect = function (val) {
    return {
        toBe: function (arg) {
            if (val === arg) {
                return true;
            }
            throw "Not Equal";
        },

        notToBe: function (arg) {
            if (val !== arg) {
                return true;
            }
            throw "Equal";
        }
    }
};

/**
 * 2665. Counter II
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter2 = function (init) {
    const initCount = init;
    let count = init;
    return {
        increment: function () {
            return ++count;
        },
        decrement: function () {
            return --count;
        },
        reset: function () {
            count = initCount;
            return count;
        },
    }
};

/**
 * 2635. Apply Transform Over Each Element in Array
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function (arr, fn) {
    let newArray = [];
    for (let i = 0; i < arr.length; i++) {
        newArray.push(fn(arr[i],i));
    }
    return newArray;
};

/**
 * 2634. Filter Elements from Array
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let newArray = [];
    arr.forEach((num,i) => {
        if (fn(num,i)) {
            newArray.push(num);
        }
    })
    return newArray;
};

/**
 * 2626. Array Reduce Transformation
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    nums.forEach((num) => {
        init = fn(init,num)
    })
    return init;
};