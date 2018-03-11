job('example') {
    triggers {
        cron('*/2 * * * *')
    }
    steps {
        shell('echo START')
    }
}