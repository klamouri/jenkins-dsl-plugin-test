job('example') {
    triggers {
        cron('*/2 * * * *')
    }
    steps {
        shell('echo START')
    }
}

job('example-2') {
    triggers {
        cron('*/4 * * * *')
    }
    steps {
        shell('echo START 2')
    }
}