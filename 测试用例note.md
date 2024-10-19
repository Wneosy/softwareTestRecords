### 测试用例设计方法

——软件中的黑盒测试方法

测试用例定义：是为了特定的目的而设计的一组有测试输入、执行条件，预期结果的输出（文档）

测试用例构成要素

<img src="https://gitee.com/Black_aura/picture/raw/master/img/用例设计.png" alt="用例设计" style="zoom:50%;" />

#### 等价类

等价类概念：在所有测试的数据中，具有某种共同特征的数据子集

- 有效等价类
- 无效等价类

线性情况/非线性情况 

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019154750277.png" alt="image-20241019154750277" style="zoom: 50%;" />

设计步骤：

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019155255645.png" alt="image-20241019155255645" style="zoom: 33%;" />

#### 边界值

大量的错误是发生在输入或输出范围的边界上，而不是在输入范围的内部

边界值：选取正好等于、刚刚好大于或刚刚好小于边界值作为测试数据

有效边界+无效边界

- 上点
- 离店
- 内点

(0，100)

上点：0，100

离点：1，99

内点：50

[0,100]

上点：0，100

离点：-1，101

内点：50

[0,100)

上点：0，100

离点：-1，99

内点：50

(0,100]

上点：0，100

离点：1，101

内点：50

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019170821931.png" alt="image-20241019170821931" style="zoom: 25%;" />



#### 判定表法

使用等价类方法时对于输入域及输入域存在关联时无法覆盖

条件桩	条件项

动作桩	动作项

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019173704815.png" alt="image-20241019173704815" style="zoom: 25%;" />

#### 因果图

考虑所有输入/输出条件的相互制约关系以及组合关系

考虑输入条件之间的依赖关系

再根据分析的关系转换为判定表的规则

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019184937011.png" alt="image-20241019184937011" style="zoom:33%;" />

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019185042608.png" alt="image-20241019185042608" style="zoom:33%;" />

#### 状态迁移图

首先要找出所有的状态，然后再分析各个状态之间的转换条件和转换路径。然后从其状态迁移路径覆盖的角度来设计测试用例。（多用于协议测试）

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019191103006.png" alt="image-20241019191103006" style="zoom:25%;" />

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019191614020.png" alt="image-20241019191614020" style="zoom: 25%;" />

#### 场景法

软件几乎都是用事件触发来控制流程的，事件触发时的情景便形成了场景，而同一事件不同的触发顺序和处理结果就形成事件流。

- 基本流
- 备选流
- (异常流)

 <img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019192523327.png" alt="image-20241019192523327" style="zoom:25%;" />

![image-20241019192735893](https://gitee.com/Black_aura/picture/raw/master/img/image-20241019192735893.png)

#### 正交实验法

正交实验设计方法：是由数理统计学科中正交实验方法进化出的一种测试多条件多输入的用例设计方法，从大量的（实验）数据（测试例子）中挑选适量的，有代表性的点（例），从而合理地安排实验（测试）的一种科学实验设计方法。

条件：因子

取值：水平

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019194925623.png" alt="image-20241019194925623" style="zoom:33%;" />

#### 错误推测法

- 经验
- 直觉

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019195621486.png" alt="image-20241019195621486" style="zoom: 33%;" />

#### 总结

<img src="https://gitee.com/Black_aura/picture/raw/master/img/image-20241019200038801.png" alt="image-20241019200038801" style="zoom:33%;" />

#### 比赛测试用例文档条目

测试用例编号：被测软件名_功能模块名\_附加说明(可选)\_三位数编号

模块名称：按照测试**需求文档**中给出的测试模块命名，以区分不同的测试模块

功能索引：根据**功能说明书**的说明以实际情况命名

用例说明：描述该条用例主要测试了什么，如"合法出发日期下的车票查询"

前置条件

执行步骤

输入数据：执行该条测试用例时的输入数据

预期结果：执行该条数据时的预期结果

截图文件：命名方式以测试用例编号.jpg/.png进行命名