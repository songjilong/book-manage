<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="编号"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="书名"
                    width="150">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    width="150">
            </el-table-column>
            <el-table-column
                    label="操作"
                    width="150">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">编辑</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
                background
                layout="prev, pager, next"
                :page-size=this.size
                :total=this.total
                @current-change="page">
        </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            edit(row) {
                console.log(row);
                this.$router.push({
                    path: '/updateBook',
                    query: {
                        id: row.id
                    }
                });
            },
            deleteBook(row) {
                this.$confirm('确定删除要《'+row.name+"》吗？", '警告', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'error'
                }).then(() => {
                    axios.delete('http://localhost:8181/book/delete/' + row.id).then((resp) => {
                        window.location.reload();
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });

            },
            page(currentPage) {
                const _this = this;
                axios.get('http://localhost:8181/book/page/' + currentPage + '/' + this.size).then((resp) => {
                    _this.tableData = resp.data.content
                    _this.total = resp.data.totalElements
                }).catch();
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8181/book/page/1/' + this.size).then((resp) => {
                console.log(resp)
                _this.tableData = resp.data.content
                _this.total = resp.data.totalElements
            }).catch();
        },
        data() {
            return {
                total: 0,
                size: 6,
                tableData: null
            }
        }
    }
</script>

<style scoped>

</style>