package develon.spring

import develon.spring.log.log

class Init {
    companion object {
        init {
            log.d("MySpringBoot库加载成功!")
        }
    }

    /**
     * 获取MySpringBoot作者
     */
    fun getAuthorName() = "develon"

    /**
     * 获取MySpringBoot版本号
     */
    fun getVersion() = "0.1"
}
