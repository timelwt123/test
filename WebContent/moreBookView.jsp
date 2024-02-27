<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>批量进货</title>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">
<script src="js/vue.js"></script>
<script src="element-ui/lib/index.js"></script>

</head>
<body>
<template>
  <div>
    <el-table ref="multipleTable"
              :data="tableData"
              tooltip-effect="dark"
              style="width: 100%"
              @selection-change="handleSelectionChange">
      <el-table-column type="selection"
                       width="55">
      </el-table-column>
      <el-table-column label="日期"
                       width="120">
        <template slot-scope="scope">{{ scope.row.date }}</template>
      </el-table-column>
      <el-table-column prop="name"
                       label="姓名"
                       width="120">
      </el-table-column>
      <el-table-column prop="address"
                       label="地址"
                       show-overflow-tooltip>
      </el-table-column>
    </el-table>
  </div>
</template>
<script>
export default {
  data () {
    return {
      selectionKeys: [1, 2],
      tableData: [{
        id: 1,
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        id: 2,
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        id: 3,
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }],
    }
  },
  // 注意 toggleRowSelection 方法的 row 必须是从 tableData 中提出来的
  // 只有这样获取的 row 才能确定哪一行数据被勾选  涉及到复杂数据指向地址问题
  mounted () {
    const { selectionKeys, tableData } = this
    selectionKeys.forEach(key => {
      tableData.forEach(row => {
        if (row.id == key) {
          this.$refs.multipleTable.toggleRowSelection(row, true);
        }
      })
    })

    // 错误示范  虽然数据一摸一样  但是指向地址不同  并不能视为同一条数据
    // let selectionRows = [{
    //   id: 1,
    //   date: '2016-05-03',
    //   name: '王小虎',
    //   address: '上海市普陀区金沙江路 1518 弄'
    // }, {
    //   id: 2,
    //   date: '2016-05-02',
    //   name: '王小虎',
    //   address: '上海市普陀区金沙江路 1518 弄'
    // }]
    // selectionRows.forEach(row => {
    //   this.$refs.multipleTable.toggleRowSelection(row, true);
    // })
  },
  methods: {
    handleSelectionChange (rows) {
      this.selectionKeys = rows.map(item => item.id);
      console.log(this.selectionKeys)
    },
  }
}
</script>
<style scoped lang="less">
</style>

</body>
</html>