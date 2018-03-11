job('example') {
    triggers {
        cron('*/2 * * * *')
    }
    steps {
        shell('echo START')
    }
}


job('example-4') {
    triggers {
        cron('*/3 * * * *')
    }
    steps {
        shell('echo START 2')
    }
}