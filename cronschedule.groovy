job('example') {
    triggers {
        cron('*/2 * * * *')
    }
    steps {
        shell('echo START')
    }
}


job('example-3') {
    triggers {
        cron('*/4 * * * *')
    }
    steps {
        shell('echo START 2')
    }
}