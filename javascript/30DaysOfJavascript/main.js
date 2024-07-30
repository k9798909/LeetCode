/**
 * 2667. Create Hello World Function
 * @return {Function}
 */
var createHelloWorld = function () {
  return function (...args) {
    return "Hello World";
  };
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
    },
  };
};

/**
 * 2665. Counter II
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter2 = function (init) {
  let initCount = init;
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
  };
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
    newArray.push(fn(arr[i], i));
  }
  return newArray;
};

/**
 * 2634. Filter Elements from Array
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function (arr, fn) {
  let newArray = [];
  arr.forEach((num, i) => {
    if (fn(num, i)) {
      newArray.push(num);
    }
  });
  return newArray;
};

/**
 * 2626. Array Reduce Transformation
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function (nums, fn, init) {
  nums.forEach((num) => {
    init = fn(init, num);
  });
  return init;
};

/**
 * 2629. Function Composition
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function (functions) {
  return function (x) {
    functions.reverse().forEach((fn) => {
      x = fn(x);
    });
    return x;
  };
};

/**
 * 2703. Return Length of Arguments Passed
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function (...args) {
  return args.length;
};

/**
 * 2666. Allow One Function Call
 * @param {Function} fn
 * @return {Function}
 */
var once = function (fn) {
  let doFn = fn;
  return function (...args) {
    if (doFn) {
      let result = doFn(...args);
      doFn = undefined;
      return result;
    }
    return doFn;
  };
};

/**
 * 2623. Memoize
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
  let cache = new Map();
  return function (...args) {
    let key = args.toString();
    if (cache.has(key)) {
      return cache.get(key);
    } else {
      let result = fn(...args);
      cache.set(key, result);
      return result;
    }
  };
}

/**
 * 2723. Add Two Promises
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function (promise1, promise2) {
  let num1 = await promise1;
  let num2 = await promise2;
  return num1 + num2;
};

/**
 * 2621. Sleep
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
  return new Promise((resolve, _) => {
    setTimeout(() => resolve(millis), millis);
  });
}

/**
 * 2715. Timeout Cancellation
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function (fn, args, t) {
  let timeout = setTimeout(fn, t, ...args);
  return () => {
    clearTimeout(timeout);
  };
};

/**
 * 2725. Interval Cancellation
 * @param {Function} fn
 * @param {Array} args
 * @param {number} t
 * @return {Function}
 */
var cancellable = function (fn, args, t) {
  fn(...args);
  let interval = setInterval(fn, t, ...args);
  return () => {
    clearInterval(interval);
  };
};

/**
 * 2637. Promise Time Limit
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function (fn, t) {
  return async function (...args) {
    let timeout = new Promise((_, reject) => {
      setTimeout(() => reject("Time Limit Exceeded"), t);
    });

    let result = new Promise((resolve, _) => {
      resolve(fn(...args));
    });
    return Promise.race([result, timeout]);
  };
};

/**
 * 2622. Cache With Time Limit
 */
class TimeLimitedCache {
  constructor() {
    this.storeMap = new Map();
    this.timeoutMap = new Map();
  }

  /**
   * @param {number} key
   * @param {number} value
   * @param {number} duration time until expiration in ms
   * @return {boolean} if un-expired key already existed
   */
  set = function (key, value, duration) {
    let notExist = this.storeMap.has(key);

    if (this.timeoutMap.has(key)) {
      clearTimeout(this.timeoutMap.get(key));
    }

    this.storeMap.set(key, value);

    let timeoutId = setTimeout(() => {
      this.storeMap.delete(key);
    }, duration);

    this.timeoutMap.set(key, timeoutId);

    return notExist;
  };

  /**
   * @param {number} key
   * @return {number} value associated with key
   */
  get = function (key) {
    if (this.storeMap.has(key)) {
      return this.storeMap.get(key);
    }
    return -1;
  };

  /**
   * @return {number} count of non-expired keys
   */
  count = function () {
    return this.storeMap.size;
  };
}

/**
 * 2627. Debounce
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function (fn, t) {
  let timeoutId;
  return function (...args) {
    if (timeoutId) {
      clearTimeout(timeoutId);
    }
    timeoutId = setTimeout(fn, t, ...args);
  };
};

/**
 * 2721. Execute Asynchronous Functions in Parallel
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function (functions) {
  return new Promise((resolve, reject) => {
    let resultArray = [];
    let cnt = 0;
    functions.forEach((fn, index) => {
      fn()
        .then((result) => {
          resultArray[index] = result;
          cnt++;

          if (cnt == functions.length) {
            resolve(resultArray);
          }
        })
        .catch((e) => {
          reject(e);
        });
    });
  });
};

/**
 * 2727. Is Object Empty
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function (obj) {
  if (!obj) {
    return true;
  }
  return Object.keys(obj).length === 0;
};

/**
 * 2677. Chunk Array
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function (arr, size) {
  let chunkArray = [];
  for (let i = 0; i < arr.length; i += size) {
    chunkArray.push(arr.slice(i, i + size));
  }
  return chunkArray;
};

/**
 * 2619. Array Prototype Last
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function () {
  if (this.length === 0) {
    return -1;
  }
  return this[this.length - 1];
};

/**
 * 2631. Group By
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function (fn) {
  let obj = {};
  this.forEach((t) => {
    let key = fn(t);
    if (obj[key]) {
      obj[key].push(t);
    } else {
      obj[key] = [t];
    }
  });

  return obj;
};

/**
 * 2724. Sort By
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
var sortBy = function (arr, fn) {
  return arr.sort((a, b) => fn(a) - fn(b));
};

/**
 * 2722. Join Two Arrays by ID
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function (arr1, arr2) {
  let join = [];
  arr1.push(...arr2);
  arr1.forEach((t) => {
    const idx = t.id;
    if (!!join[idx]) {
      join[idx] = Object.assign(join[idx], t);
    } else {
      join[idx] = t;
    }
  });
  return join.filter((t) => !!t);
};

/**
 * 2625. Flatten Deeply Nested Array
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
  const flatArray = [];
  const flatFn = (arr, n) =>
    arr.forEach((t) => {
      if (Array.isArray(t) && n > 0) {
        flatFn(t, n - 1);
      } else {
        flatArray.push(t);
      }
    });

  flatFn(arr, n);
  return flatArray;
};

/**
 * 2705. Compact Object
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
  if (Array.isArray(obj)) {
    obj = obj.filter((t) => Boolean(t));
  }

  Object.keys(obj).forEach((key) => {
    if (!Boolean(obj[key])) {
      delete obj[key];
    } else if (Array.isArray(obj[key]) || typeof obj[key] === "object") {
      obj[key] = compactObject(obj[key]);
    }
  });
  return obj;
};

/**
 * 2694. Event Emitter
 */
class EventEmitter {
  constructor() {
    this.eventList = {};
  }

  /**
   * @param {string} eventName
   * @param {Function} callback
   * @return {Object}
   */
  subscribe(eventName, callback) {
    if (!this.eventList[eventName]) {
      this.eventList[eventName] = [];
    }
    const key = this.eventList[eventName].length;
    this.eventList[eventName][key] = callback;

    return {
      unsubscribe: () => {
        this.eventList[eventName][key] = null;
        if (this.eventList[eventName].filter((t) => Boolean(t)).length == 0) {
          delete this.eventList[eventName];
        }
      },
    };
  }

  /**
   * @param {string} eventName
   * @param {Array} args
   * @return {Array}
   */
  emit(eventName, args = []) {
    const fns = this.eventList[eventName];
    if (fns) {
      return fns.filter((t) => Boolean(t)).map((fn) => fn(...args));
    } else {
      return [];
    }
  }
}

{
  /**
   * 2695. Array Wrapper
   * @param {number[]} nums
   * @return {void}
   */
  var ArrayWrapper = function (nums) {
    this.nums = nums;
  };

  /**
   * @return {number}
   */
  ArrayWrapper.prototype.valueOf = function () {
    return this.nums.reduce((num1, nym2) => num1 + nym2, 0);
  };

  /**
   * @return {string}
   */
  ArrayWrapper.prototype.toString = function () {
    return "[" + this.nums.join(",") + "]";
  };
}

/**
 * 2726. Calculator with Method Chaining
 */
class Calculator {
  /**
   * @param {number} value
   */
  constructor(value) {
    this.value = value;
  }

  /**
   * @param {number} value
   * @return {Calculator}
   */
  add(value) {
    this.value += value;
    return this;
  }

  /**
   * @param {number} value
   * @return {Calculator}
   */
  subtract(value) {
    this.value -= value;
    return this;
  }

  /**
   * @param {number} value
   * @return {Calculator}
   */
  multiply(value) {
    this.value *= value;
    return this;
  }

  /**
   * @param {number} value
   * @return {Calculator}
   */
  divide(value) {
    if (value == 0) {
      throw "Division by zero is not allowed";
    }

    this.value /= value;
    return this;
  }

  /**
   * @param {number} value
   * @return {Calculator}
   */
  power(value) {
    this.value = Math.pow(this.value, value);
    return this;
  }

  /**
   * @return {number}
   */
  getResult() {
    return this.value;
  }
}
